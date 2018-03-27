package com.neosoft.rec_pro.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.rec_pro.dao.DepartmentDao;
import com.neosoft.rec_pro.dao.TechnologyDao;
import com.neosoft.rec_pro.dao.UserDao;
import com.neosoft.rec_pro.model.Department;
import com.neosoft.rec_pro.model.Technology;
import com.neosoft.rec_pro.model.User;
import com.neosoft.rec_pro.service.UserService;

@Service
public class UserServiceImpl implements UserService 
{

	@Autowired
	UserDao userDao;
	
	@Autowired
	DepartmentDao departmentDao;
	
	@Autowired
	TechnologyDao technologyDao;
	
	@Override
	public User getUserById(Integer user_id)
	{
		User user=userDao.findOne(user_id);
		return user;
	}

	@Override
	public List<Department> getDepartList() 
	{
		List<Department> deptList=departmentDao.findAll();
		System.out.println("size of list in serviceImple deptList"+deptList.size());
		return deptList;
	}

	@Override
	public List<Technology> getTechnologies()
	{
		List<Technology> techList=technologyDao.findAll();
		System.out.println("size of list in serviceImple techList"+techList.size());
		return techList;
	}
	
	@Override
	public Department getDepartByName(String deptName) 
	{
		Department dept=departmentDao.findByDeptName(deptName);
		System.out.println("dept in serviceImple deptList"+dept);
		return dept;
	}
	
	@Override
	public List<User> getHrList()
	{
		List<User> hrList=userDao.getHrList();
		return hrList;
	}

}
