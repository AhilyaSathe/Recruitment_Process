package com.neosoft.rec_pro.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.rec_pro.dao.InterviewerDao;
import com.neosoft.rec_pro.model.Department;
import com.neosoft.rec_pro.model.Interviewer;
import com.neosoft.rec_pro.service.InterviewerService;

@Service
public class InterviewerServiceImpl implements InterviewerService
{
	@Autowired
	InterviewerDao interviewerDao;
	
	
	@Override
	public void saveInterviewer(Interviewer interviewer)
	{
		interviewerDao.save(interviewer);
		
	}


	@Override
	public List<Interviewer> getInterviewerList(Department department)
	{
		List<Interviewer> list=interviewerDao.findByDepartment(department);
		return list;
	}

}
