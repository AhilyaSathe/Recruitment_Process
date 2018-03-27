package com.neosoft.rec_pro;

/*import java.io.UnsupportedEncodingException;

import it.ozimov.springboot.mail.configuration.EnableEmailTools;*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class RecruitmentProcessApplication {

	public static void main(String[] args)  
	{
		System.out.println("in application java");
		SpringApplication.run(RecruitmentProcessApplication.class, args);
		/*RecruitmentProcessApplicationTests obj=new RecruitmentProcessApplicationTests();
		obj.testSendEmail();*/
	}
}
