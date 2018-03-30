package com.neosoft.rec_pro.service;

import java.util.List;

import com.neosoft.rec_pro.model.Department;
import com.neosoft.rec_pro.model.Interviewer;
import com.neosoft.rec_pro.model.User;

public interface InterviewerService
{
	public List<Interviewer> getInterviewerList(Department department);
	public void saveInterviewer(Interviewer interviewer);
}
