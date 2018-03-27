package com.neosoft.rec_pro.serviceImpl;

import java.io.File;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.neosoft.rec_pro.dao.EmailDao;
import com.neosoft.rec_pro.model.Candidate;
import com.neosoft.rec_pro.model.ScheduleInterviews;
import com.neosoft.rec_pro.service.EmailService;




@Service
public class EmailServiceImpl implements EmailService 
{
	
	
	@Autowired
	JavaMailSender javaMailSender;
	
	@Autowired
	EmailDao emailDao;

	
	@Override
	public void testEmail(String emailIdTo, Date date, Candidate candidate,String hRName)
	{
		
		String pathToAttachment=candidate.getCv();
		System.out.println("in testEmial method");
		 MimeMessage message = javaMailSender.createMimeMessage();
	      
		    MimeMessageHelper helper;
			try {
				helper = new MimeMessageHelper(message, true);
			
		    helper.setTo(emailIdTo); 
		    helper.setSubject("InterviewDetails"); 
		    String matter="Hi, \n\t PFA.\n\t Interview is schedule on \n\t "+date+"\n\t Please check the details of applicant in cv. \n\n\n\n Thanks & Regards \n"+hRName;
		    helper.setText(matter);
			
        FileSystemResource file 
        = new FileSystemResource(new File(pathToAttachment));
        helper.addAttachment("CV", file);
        
        javaMailSender.send(message);
        
       
        
        
        
        
			} catch (MessagingException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}




	@Override
	public void saveEmail(ScheduleInterviews scheduleInterviews)
	{
		System.out.println("interview status in dao is : "+scheduleInterviews.getScheduledStatus());
		emailDao.save(scheduleInterviews);
		
	}

	
	
	
}