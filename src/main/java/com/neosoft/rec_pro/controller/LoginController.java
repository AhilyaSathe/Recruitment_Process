package com.neosoft.rec_pro.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.neosoft.rec_pro.model.Candidate;
import com.neosoft.rec_pro.model.Department;
import com.neosoft.rec_pro.model.Technology;
import com.neosoft.rec_pro.model.User;
import com.neosoft.rec_pro.service.LoginService;
import com.neosoft.rec_pro.service.UserService;

@RestController
public class LoginController
{
	@Autowired
	LoginService loginService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/checkLogin", method=RequestMethod.POST)
	public ModelAndView loginView(@RequestParam("username") String username,@RequestParam String password,HttpServletRequest request)
	{
		System.out.println("in checkLogin"+username +" "+password);
		User user=loginService.findByUsernameAndPassword(username,password);
		
		
		System.out.println(user);
		 if(user!=null)
		 {
			 String firstname=user.getName();
			 HttpSession session=request.getSession();
			 session.setAttribute("user", user);
			 session.setAttribute("firstname", firstname);
			 if(user.getRole().equalsIgnoreCase("HR"))
				 return new ModelAndView("index");
			 else if(user.getRole().equalsIgnoreCase("TL"))
				 return new ModelAndView("homePageTL");
		 }
		 /*else*/
			 return new ModelAndView("loginPage");
		/*return null;*/
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView registerView()
	{
		System.out.println("in loginView");
		return new ModelAndView("register");
	}
	
	
	@RequestMapping(value="/findTlWithTech/{tech}", method=RequestMethod.GET)
	public List<User> findTlWithTech(@PathVariable("tech") String tech)
		{
		System.out.println("in findTlWithTech"+tech);
		Department department=userService.getDepartByName(tech);
		//Department d=tech;
		/*Technology tech=*/
		List<User> list=loginService.getTlWithDept(department);
		System.out.println("size of list "+list.size());
		
		return list;
		
	}
	
	
	//imp:if you send any string with . operator,it is consider as url from . and data is truncated ,so to send . as string use below format in mapping
	@RequestMapping(value="/checkLoginOfCandidate/{emailId:.+}", method=RequestMethod.POST,produces="text/plain")
	public String checkLoginOfCandidate(@PathVariable("emailId") String emailId,HttpServletRequest request)
	{
		System.out.println("in loginCandidate "+emailId);
		Candidate candidate=loginService.findByEmailId(emailId);
		if(candidate!=null)
		{
			Integer candidate_id=candidate.getCandidate_id();
			System.out.println("if"+candidate.getCandidate_id());
			HttpSession session=request.getSession();
			session.setAttribute("candidate", candidate);
			session.setAttribute("candidate_id", candidate_id);
			return "/homePageCandidate";
		}
		else
		{
			System.out.println("else");
			return "/loginCandidate";
		}
	}

}
