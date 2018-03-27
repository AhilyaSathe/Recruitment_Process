package com.neosoft.rec_pro.service;

import java.util.Date;

import com.neosoft.rec_pro.model.Candidate;
import com.neosoft.rec_pro.model.ScheduleInterviews;



public interface EmailService
{
	
	public void saveEmail(ScheduleInterviews scheduleInterviews);
	public void testEmail(String emailIdTo, Date date, Candidate candidate,String hRName);
}
