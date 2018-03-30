package com.neosoft.rec_pro.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.rec_pro.dao.ScheduleInterviewDao;
import com.neosoft.rec_pro.model.FinalSelectionStatus;
import com.neosoft.rec_pro.model.ScheduleInterviews;
import com.neosoft.rec_pro.service.ScheduleInterviewService;

@Service
public class ScheduleInterviewServiceImpl implements ScheduleInterviewService
{
	@Autowired
	ScheduleInterviewDao scheduleInterviewDao;

	@Override
	public List<ScheduleInterviews> getScheduledInterviews(Integer userId) 
	{
		List<ScheduleInterviews> obj=scheduleInterviewDao.findAllByUserId(userId);
		return obj;
	}

	@Override
	public void acceptedStatus(Integer scheduleId) 
	{
		//System.out.println("value of status in serviceImpl : "+FinalSelectionStatus.select.name());
		/*boolean flag=*/scheduleInterviewDao.updateAcceptedStatus(scheduleId);
		/*if (flag)
			return true;
		else 
			return false;*/
		//get scheduled details
		
		
	}

	@Override
	public boolean getScheduledStatus(Integer scheduledId)
	{
		boolean flag=scheduleInterviewDao.getScheduledStatus(scheduledId);
		System.out.println("value in dao : "+flag);
		return false;
	}

	@Override
	public boolean rejectedStatus(Integer scheduledId)
	{
		/*scheduleInterviewDao.getRejectedStatus(scheduledId,FinalSelectionStatus.reject);*/
		scheduleInterviewDao.getRejectedStatus(scheduledId);
		System.out.println("value in dao : ");
		return false;
	}

	@Override
	public ScheduleInterviews getScheduleInterview(Integer scheduledId)
	{
		ScheduleInterviews scheduleInterview=scheduleInterviewDao.findOne(scheduledId);
		return scheduleInterview;
	}

	@Override
	public ScheduleInterviews getScheduleInterviewsByCandidateID(Integer can_id)
	{
		
		return scheduleInterviewDao.getScheduleInterviewsByCandidateId(can_id);
	}

}
