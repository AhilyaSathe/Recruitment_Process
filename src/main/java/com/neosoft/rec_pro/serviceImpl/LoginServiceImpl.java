package com.neosoft.rec_pro.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.rec_pro.dao.CandidateDao;
import com.neosoft.rec_pro.dao.LoginDao;
import com.neosoft.rec_pro.model.Candidate;
import com.neosoft.rec_pro.model.Department;
import com.neosoft.rec_pro.model.Technology;
import com.neosoft.rec_pro.model.User;
import com.neosoft.rec_pro.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService
{
	@Autowired
	LoginDao loginDao;
	
	@Autowired
	CandidateDao candidateDao;

	@Override
	public User findByUsernameAndPassword(String username,String password)
	{
		User user= loginDao.findByUsernameAndPassword(username,password);
		return user;
	}

	@Override
	public List<User> getTlWithDept(Department tech) 
	{
		String role="TL";
		List<User> tlList=loginDao.findByDepartment(tech,role);
		return tlList;
	}

	@Override
	public Candidate findByEmailId(String emailId)
	{
		Candidate candidate=candidateDao.findByEmailId(emailId);
		System.out.println("candidate in serviceImpl is : "+candidate);
		return candidate;
	}
	

}
