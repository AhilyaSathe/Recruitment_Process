package com.neosoft.rec_pro.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.rec_pro.model.Candidate;
import com.neosoft.rec_pro.model.Department;
import com.neosoft.rec_pro.model.Technology;
import com.neosoft.rec_pro.model.User;

/*@Repository*/
public interface LoginService 
{
	
	public User findByUsernameAndPassword(String username,String password);
	public List<User> getTlWithDept(Department tech);
	public Candidate findByEmailId(String emailId);
}
