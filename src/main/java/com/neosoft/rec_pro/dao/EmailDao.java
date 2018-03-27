package com.neosoft.rec_pro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.neosoft.rec_pro.model.Department;
import com.neosoft.rec_pro.model.ScheduleInterviews;
import com.neosoft.rec_pro.model.User;

public interface EmailDao extends JpaRepository<ScheduleInterviews, Integer> 
{
	
	
}