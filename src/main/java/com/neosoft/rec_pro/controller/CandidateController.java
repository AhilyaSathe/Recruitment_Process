package com.neosoft.rec_pro.controller;


import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.felix.framework.resolver.CandidateComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.neosoft.rec_pro.model.ApplicationDetails;
import com.neosoft.rec_pro.model.Candidate;
import com.neosoft.rec_pro.model.CommonCandidate;
import com.neosoft.rec_pro.model.Educational_Details;
import com.neosoft.rec_pro.model.Employment_Details;
import com.neosoft.rec_pro.model.ScheduleInterviews;
import com.neosoft.rec_pro.model.Technology;
import com.neosoft.rec_pro.service.CandidateService;

@RestController
public class CandidateController 
{
	@Autowired
	CandidateService candidateService;
	
	@RequestMapping(value="/addCandidate",method=RequestMethod.POST)
	public ModelAndView addCandidate(@RequestBody Candidate candidate)
	{
		candidateService.addCandidate(candidate);
		return new ModelAndView("index");
		
	}
	
	@RequestMapping(value="/listOfCandidates",method=RequestMethod.GET)
	public List<Candidate> listOfCandidates()
	{
		
		List<Candidate> listOfCand=candidateService.listOfCandidates();
		return listOfCand;
		
	}
	
	@RequestMapping(value="/deleteCandidate/{id}",method=RequestMethod.POST)
	public List<Candidate> deleteCandidate(@PathVariable("id") String id)
	{
		Integer idCan=Integer.valueOf(id);
		candidateService.deleteCandidate(idCan);
		List<Candidate> listOfCand=candidateService.listOfCandidates();
		return listOfCand;
		
		
	}
	
	@RequestMapping(value="/getApplicantById/{id}",method=RequestMethod.POST)
	public Candidate getApplicantById(@PathVariable("id") String id)
	{
		Integer idCan=Integer.valueOf(id);
		Candidate candidate=candidateService.getApplicantById(idCan);
		
		return candidate;
		
		
	}
	
	
	@RequestMapping(value="/updateCandidateById",method=RequestMethod.POST)
	public ResponseEntity updateCandidateById(@RequestBody Candidate candidate)
	{
		System.out.println("in updateController"+candidate.getCandidate_id() +" "+candidate.getLastName());
		Integer idCan=candidate.getCandidate_id();
		candidateService.updateCandidate(candidate,idCan);
		
		return new ResponseEntity(HttpStatus.OK);
		
		
	}
	
	
	@RequestMapping(value="/getScheduleStatusOfCandidate/{id}",produces="text/html")
	public @ResponseBody String getScheduleStatusOfCandidate(@PathVariable("id") String candidate_id)
	{
		System.out.println("candidate_id is : "+candidate_id);
		Integer cand_id=Integer.valueOf(candidate_id);
		System.out.println(cand_id);
		
		
		
		String status=candidateService.getScheduleStatusOfCandidate(cand_id);
		System.out.println("status in controller: "+status);
		if(status==null)
		{
			System.out.println("in null");
			status="pending";
			return status;
		}
		else
		return status;
		
	}
	
	/*@RequestMapping(value="/saveCandidate",method=RequestMethod.POST)
	public void saveCandidateDetails(@RequestBody CommonCandidate dataObj)
	{
			System.out.println("check method");
	}*/
	
	
	@RequestMapping(value="/saveCandidate",method=RequestMethod.POST)
	public void saveCandidateDetails(@RequestBody CommonCandidate dataObj,HttpServletRequest request)
	{
		
		Candidate candidate=dataObj.getCandidate();
		HttpSession session=request.getSession();
		
		
		Candidate candidate1= (Candidate) session.getAttribute("candidate");
		Integer candidate_id=candidate1.getCandidate_id();
		
		
		Set<Educational_Details> educationDetails=dataObj.getEducational_Details();
		Set<Employment_Details> employment_Details=dataObj.getEmployment_Details();
		
		
		//setting candidate id to each record
		for (Employment_Details employment_Details2 : employment_Details) 
		{
			employment_Details2.setCandidate(candidate1);
		}
		
		for (Educational_Details educational_Details : educationDetails)
		{
			educational_Details.setCandidate(candidate1);
		}
		
		
		//set older values which are stored by HR for the candidate
		candidate.setFirstName(candidate1.getFirstName());
		candidate.setLastName(candidate1.getLastName());
		candidate.setEducational_Details(educationDetails);
		candidate.setEmployment_Details(employment_Details);
		candidate.setEmailId(candidate1.getEmailId());
		candidate.setCv(candidate1.getCv());
		candidate.setExperience(candidate1.getExperience());
		candidate.setTechnology(candidate1.getTechnology());
	
		candidateService.saveCandidateDetails(candidate, candidate_id);
		
		
	}
	
	
}
