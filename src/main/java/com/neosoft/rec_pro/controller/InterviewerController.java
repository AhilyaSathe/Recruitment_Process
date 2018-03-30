package com.neosoft.rec_pro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.rec_pro.model.Department;
import com.neosoft.rec_pro.model.Interviewer;
import com.neosoft.rec_pro.model.User;
import com.neosoft.rec_pro.service.InterviewerService;

@RestController
public class InterviewerController 
{
	@Autowired
	InterviewerService interviewerService;
	
	
	
	@RequestMapping(value="/getInterviewerList" ,method=RequestMethod.GET)
	public List<Interviewer> getInterviewerList(HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		User userTL=(User)session.getAttribute("user");
		
		Department department=userTL.getDepartment();
		System.out.println("getHrList ");
		List<Interviewer> getInterviewerList=interviewerService.getInterviewerList(department);
		for (Interviewer user : getInterviewerList) 
		{
			System.out.println("Interviewer id: "+user.getInerviewer_id());
		}
		System.out.println(" getInterviewerList size is "+getInterviewerList.size());
		return getInterviewerList;
	}
	
	@RequestMapping(value="/addInterviewer",method=RequestMethod.POST)
	public void addInterviewer(@RequestBody Interviewer interviewer,HttpServletRequest request)
	{
		System.out.println(interviewer.getEmailId()+interviewer.getUsername());
		
		//get Tl from the session to get its department and technology
		HttpSession session=request.getSession();
		User userTL=(User)session.getAttribute("user");
		
		//add that same department and technology to interviewer
		interviewer.setRole("Interviewer");
		interviewer.setDepartment(userTL.getDepartment());
		interviewer.setTechnology(userTL.getTechnology());
		
	
		interviewerService.saveInterviewer(interviewer);
		
		//return new ModelAndView("homePageTL");
		
	}

}
