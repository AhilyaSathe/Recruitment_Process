package com.neosoft.rec_pro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.rec_pro.model.Candidate;
import com.neosoft.rec_pro.model.FinalSelectionStatus;
import com.neosoft.rec_pro.model.Interviewer;
import com.neosoft.rec_pro.model.ScheduleInterviews;
import com.neosoft.rec_pro.model.User;
import com.neosoft.rec_pro.service.CandidateService;
import com.neosoft.rec_pro.service.EmailService;
import com.neosoft.rec_pro.service.ScheduleInterviewService;

@RestController
public class TlController 
{
	@Autowired
	ScheduleInterviewService scheduleInterviewService;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	CandidateService candidateService;
	
	@RequestMapping(value="/listOfscheduledCandidates")
	public List<ScheduleInterviews> getSechduledInterviews(HttpServletRequest request)
	{
		
		
		User userinSession=(User)request.getSession().getAttribute("user");
		Integer userId=userinSession.getUser_id();
		List<ScheduleInterviews> obj=scheduleInterviewService.getScheduledInterviews(userId);
		/*for (ScheduleInterviews scheduleInterviews : obj) 
		{
			System.out.println(" scheduled date is : "+scheduleInterviews.getScheduled_date());
			
		}
		*/
		return obj;
		
	}
	
	@RequestMapping(value="/getScheduledStatus/{id}",method=RequestMethod.POST)
	public void getScheduledStatus(@PathVariable String id)
	{
		System.out.println("in getScheduledStatus"+id);
		Integer scheduledId=Integer.valueOf(id);
		boolean flag=scheduleInterviewService.getScheduledStatus(scheduledId);
		
	}
	
	@RequestMapping(value="/acceptedStatus/{id}",method=RequestMethod.POST)
	public void acceptedStatus(@PathVariable String id)
	{
		System.out.println("in acceptedStatus"+id);
		Integer scheduledId=Integer.valueOf(id);
		/*boolean flag*/scheduleInterviewService.acceptedStatus(scheduledId);
		/*if(flag)
		{*/
			ScheduleInterviews scheduleInterview=scheduleInterviewService.getScheduleInterview(scheduledId);
			emailService.sendEmailToCandidate(scheduleInterview);
			System.out.println("email sent to candidate");
			
		//}
		
		
	}
	
	@RequestMapping(value="/rejectedStatus/{id}",method=RequestMethod.POST)
	public void rejectedStatus(@PathVariable String id)
	{
		System.out.println("in rejectedStatus"+id);
		Integer scheduledId=Integer.valueOf(id);
		scheduleInterviewService.rejectedStatus(scheduledId);
	}
	
	
	
	@RequestMapping(value="/assignInterview/{applicantsId}/{interviewRound}",method=RequestMethod.POST)
	public void assignInterview(@PathVariable("applicantsId") String applicantsId,@PathVariable("interviewRound") String interviewRound,@RequestBody Interviewer interviewer,HttpServletRequest request)
	{
		Integer candidatesId=Integer.valueOf(applicantsId);
		User userTL=(User)request.getSession().getAttribute("user");
		String tlName=userTL.getName();
		String toemailId=interviewer.getEmailId();
		
		//get the candidate details first
		Candidate candidate=candidateService.getApplicantById(candidatesId);
		System.out.println("cv is "+candidate.getCv());
		
		//get ScheduledInterview DEtails
		ScheduleInterviews scheduleInterviews=scheduleInterviewService.getScheduleInterviewsByCandidateID(candidatesId);
		
		boolean flag=emailService.assignInterview(tlName,interviewer,candidate,scheduleInterviews);
		if(flag)
		{
			System.out.println("email send to the interviewer");
			ScheduleInterviews scheduleInterviews2=new ScheduleInterviews();
			scheduleInterviews2.setCandidate(candidate);
			scheduleInterviews2.setEmail_subject("Scheduled interview details");
			scheduleInterviews2.setFromUser(tlName);
			scheduleInterviews2.setInterviewer(interviewer);
			scheduleInterviews2.setInterviewRound(interviewRound);
			scheduleInterviews2.setScheduled_date(scheduleInterviews.getScheduled_date());
			scheduleInterviews2.setScheduledStatus(FinalSelectionStatus.hold);
			scheduleInterviews2.setUser(userTL);
			scheduleInterviews2.setToUserId(interviewer.getInerviewer_id());
			
			emailService.saveEmail(scheduleInterviews2);
			
			
		}
		
	}
	

}
