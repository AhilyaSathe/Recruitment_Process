package com.neosoft.rec_pro.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.neosoft.rec_pro.model.Candidate;
import com.neosoft.rec_pro.model.FinalSelectionStatus;
import com.neosoft.rec_pro.model.ScheduleInterviews;
import com.neosoft.rec_pro.model.User;
import com.neosoft.rec_pro.service.EmailService;
import com.neosoft.rec_pro.service.UserService;


@RestController
public class EmailController 
{
	@Autowired
	EmailService emailservice;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/sendEmailDetails/{tl}/{date}/{interviewRound}" ,method=RequestMethod.POST)
	public ModelAndView scheduleInterview(@PathVariable("interviewRound") String interviewRound,@PathVariable("tl") String tl,@PathVariable("date") Date date,@RequestBody Candidate candidate,HttpServletRequest request )
	{
	//	System.out.println("in scheduleInterview controller"+tl +date +candidate.getCv());
		
		Integer tlId=Integer.valueOf(tl);
		User userTl=userService.getUserById(tlId);
		String emailIdTo=userTl.getEmailId();
		
		//for cheking th HR name from session after login
		String hRName=(String) request.getSession(false).getAttribute("firstname");
	//	System.out.println("firstName "+hRName);
		
		emailservice.testEmail(emailIdTo,date,candidate,hRName);
		
		ScheduleInterviews scheduleInterviews=new ScheduleInterviews();
		//scheduleInterviews.setUser(userTl);
		scheduleInterviews.setToUserId(userTl.getUser_id());
		scheduleInterviews.setCandidate(candidate);
		scheduleInterviews.setEmail_subject("Interview Details");
		scheduleInterviews.setFromUser(hRName);
		scheduleInterviews.setScheduled_date(date);
		scheduleInterviews.setScheduledStatus(FinalSelectionStatus.hold);
		scheduleInterviews.setInterviewRound(interviewRound);
		
		emailservice.saveEmail(scheduleInterviews);
		//System.out.println("after email is saved to database");
		return new ModelAndView("index");
		//return "index";
	}

}
