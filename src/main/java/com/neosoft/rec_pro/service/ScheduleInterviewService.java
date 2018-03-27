package com.neosoft.rec_pro.service;

import java.util.List;

import com.neosoft.rec_pro.model.ScheduleInterviews;

public interface ScheduleInterviewService 
{

	
	public List<ScheduleInterviews> getScheduledInterviews();
	public void acceptedStatus(Integer scheduleId);
	public boolean getScheduledStatus(Integer scheduledId);
	public boolean rejectedStatus(Integer scheduledId);
	
}
