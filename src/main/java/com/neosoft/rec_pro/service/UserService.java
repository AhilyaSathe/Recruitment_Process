package com.neosoft.rec_pro.service;

import java.util.List;

import com.neosoft.rec_pro.model.Department;
import com.neosoft.rec_pro.model.Technology;
import com.neosoft.rec_pro.model.User;



public interface UserService
{
	public User getUserById(Integer user_id);
	public List<Department> getDepartList();
	public List<Technology> getTechnologies();
	public Department getDepartByName(String deptName);
	public List<User> getHrList();
	public void addInterviewer(User user);
	
}
