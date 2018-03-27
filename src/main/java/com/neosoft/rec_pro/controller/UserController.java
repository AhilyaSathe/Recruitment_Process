package com.neosoft.rec_pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.rec_pro.model.Department;
import com.neosoft.rec_pro.model.Technology;
import com.neosoft.rec_pro.model.User;
import com.neosoft.rec_pro.service.UserService;
import com.neosoft.rec_pro.serviceImpl.UserServiceImpl;

@RestController
public class UserController
{
	@Autowired
	UserService userService;
	

	@RequestMapping(value="/getUser")
	public User getUserById(Integer user_id)
	{
		return null;
	}
	
	
	@RequestMapping(value="/getDepartList" ,method=RequestMethod.GET)
	public List<Department> getDepartList()
	{
		System.out.println("getDepartList ");
		List<Department> deptList=userService.getDepartList();
		System.out.println("size is "+deptList.size());
		return deptList;
	}
	
	@RequestMapping(value="/getTechList" ,method=RequestMethod.GET)
	public List<Technology> getTechList()
	{
		System.out.println("getTechList ");
		List<Technology> techList=userService.getTechnologies();
		System.out.println(" size is "+techList.size());
		return techList;
	}
	
	@RequestMapping(value="/getHrList" ,method=RequestMethod.GET)
	public List<User> getHrList()
	{
		System.out.println("getHrList ");
		List<User> hrList=userService.getHrList();
		for (User user : hrList) 
		{
			System.out.println("hr id: "+user.getUser_id());
		}
		System.out.println(" size is "+hrList.size());
		return hrList;
	}
}
