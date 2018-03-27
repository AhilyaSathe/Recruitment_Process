package com.neosoft.rec_pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.rec_pro.model.ScheduleInterviews;
import com.neosoft.rec_pro.service.ScheduleInterviewService;

@RestController
public class TlController 
{
	@Autowired
	ScheduleInterviewService scheduleInterviewService;
	
	@RequestMapping(value="/listOfscheduledCandidates")
	public List<ScheduleInterviews> getSechduledInterviews()
	{
		List<ScheduleInterviews> obj=scheduleInterviewService.getScheduledInterviews();
		
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
		scheduleInterviewService.acceptedStatus(scheduledId);
	}
	
	@RequestMapping(value="/rejectedStatus/{id}",method=RequestMethod.POST)
	public void rejectedStatus(@PathVariable String id)
	{
		System.out.println("in rejectedStatus"+id);
		Integer scheduledId=Integer.valueOf(id);
		scheduleInterviewService.rejectedStatus(scheduledId);
	}
	

}
