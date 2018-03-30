package com.neosoft.rec_pro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.rec_pro.model.Department;
import com.neosoft.rec_pro.model.Interviewer;

public interface InterviewerDao extends JpaRepository<Interviewer,Integer>
{

	public List<Interviewer> findByDepartment(Department department);
}
