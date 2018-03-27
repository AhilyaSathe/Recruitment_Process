package com.neosoft.rec_pro.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.rec_pro.dao.CandidateDao;
import com.neosoft.rec_pro.dao.ScheduleInterviewDao;
import com.neosoft.rec_pro.model.Candidate;
import com.neosoft.rec_pro.model.Technology;
import com.neosoft.rec_pro.service.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService
{

	@Autowired
	CandidateDao candidateDao;
	@Autowired
	ScheduleInterviewDao scheduleInterviewDao;
	
	public void addCandidate(Candidate candidate)
	{
		candidateDao.save(candidate);
		
	}
	
	public List<Candidate> listOfCandidates()
	{
		System.out.println("in dao");
		List<Candidate> list=candidateDao.findAll();
		return list;
	}

	@Override
	public void saveCV(Integer id,String path)
	{
		System.out.println("path in seerviceImpl"+path);
		candidateDao.updateCV(id, path);
		
	}

	@Override
	public void deleteCandidate(Integer id) 
	{
		candidateDao.delete(id);
		
	}

	@Override
	public Candidate getApplicantById(Integer id) 
	{
		Candidate candidate=candidateDao.findOne(id);
		return candidate;
	}

	@Override
	public void updateCandidate(Candidate candidate, Integer id) 
	{
		
		
		
		 String firstName=candidate.getFirstName();
		String lastName=candidate.getLastName();
		 String experience=candidate.getExperience();
		 Technology tech=candidate.getTechnology();
		/*private String cv;*/
		 String emailId=candidate.getEmailId();
		 System.out.println("in serviceImpl "+lastName +experience );
		 candidateDao.updateCandidate( id,firstName, lastName, experience, emailId,tech);
		 System.out.println("updated successfully");
//		/candidateDao.save(candidate,id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getScheduleStatusOfCandidate(Integer cand_id)
	{
		String s=scheduleInterviewDao.getScheduledStatusOfCandidate(cand_id);
		System.out.println("scehduled status of interview is : "+s);
		return s;
	}

	@Override
	public void saveCandidateDetails(Candidate candidate, Integer candidate_id)
	{
		candidate.setCandidate_id(candidate_id);
		candidateDao.save(candidate);
		
	}
}
