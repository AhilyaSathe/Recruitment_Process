package com.neosoft.rec_pro.service;

import java.util.List;

import com.neosoft.rec_pro.model.Candidate;
import com.neosoft.rec_pro.model.ScheduleInterviews;
import com.neosoft.rec_pro.model.Technology;

public interface CandidateService 
{
	public void addCandidate(Candidate candidate);
	public void saveCV(Integer candidate_id, String cv);
	public List<Candidate> listOfCandidates();
	public void deleteCandidate(Integer id);
	public Candidate getApplicantById(Integer id);
	public void updateCandidate(Candidate candidate,Integer id);
	public String getScheduleStatusOfCandidate(Integer cand_id);
	public void saveCandidateDetails(Candidate candidate,Integer candidate_id) ;
	
}
