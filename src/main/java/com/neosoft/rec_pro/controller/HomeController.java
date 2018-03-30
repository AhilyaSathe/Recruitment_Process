package com.neosoft.rec_pro.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neosoft.rec_pro.service.EmailService;








@Controller
public class HomeController 
{
	
	
	
	@RequestMapping("/")
	public ModelAndView test()
	{
		/*System.out.println("in controller");*/
		return new ModelAndView("loginPage");
	}
	
	@RequestMapping("/index")
	public ModelAndView testHome()
	{
		/*System.out.println("in index controller");*/
		return new ModelAndView("index");
	}
	
	@RequestMapping("/uploadApplicantCV")
	public ModelAndView uploadApplicantCV()
	{
		/*System.out.println("in index controller");*/
		return new ModelAndView("uploadApplicantCV");
	}
	
	@RequestMapping("/getApplicant")
	public ModelAndView getApplicant()
	{
		/*System.out.println("in index controller");*/
		return new ModelAndView("getApplicant");
	}
	
	
	@RequestMapping("/loginCandidate")
	public ModelAndView loginCandidate()
	{
		//System.out.println("in home controller");
		return new ModelAndView("loginCandidate");
	}
	
	@RequestMapping("/homePageCandidate")
	public ModelAndView candidateHomePage()
	{
		//System.out.println("in candidate home page");
		return new ModelAndView("homePageCandidate");
	}
	
	
	@RequestMapping("/homePageTL")
	public ModelAndView homePageTL()
	{
		//System.out.println("in candidate home page");
		return new ModelAndView("homePageTL");
	}
	
	
	

}
