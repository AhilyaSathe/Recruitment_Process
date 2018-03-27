package com.neosoft.recruitment_process;

/*import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;

import java.io.UnsupportedEncodingException;

import javax.mail.internet.InternetAddress;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.Lists;
import com.neosoft.rec_pro.model.User;*/

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class RecruitmentProcessApplicationTests {

	/*@Autowired 
    it.ozimov.springboot.mail.service.EmailService emailService; 

    @Value("${spring.mail.username}") String fromEmail; 
    @Test 
    public void testSendEmail() throws UnsupportedEncodingException { 
        User user = new User(); 
        user.setEmailId("sanaulla123@gmail.com"); 
        user.setName("Mohamed Sanaulla"); 
        final Email email = DefaultEmail.builder() 
            .from(new InternetAddress(fromEmail, "From Name"))
            .to(Lists.newArrayList(new InternetAddress(
                user.getEmailId(), user.getName()))) 
            .subject("Testing email")
            .body("Testing body ...")
            .encoding("UTF-8").build();
        emailService.send(email); 
    }
*/
}
