package com.neosoft.rec_pro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
/*import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
*/
import com.neosoft.rec_pro.serviceImpl.UserDetailsServiceImpl;

/*@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)*/
public class SecurityConfig /*extends WebSecurityConfigurerAdapter*/
{
	/*@Autowired
	private UserDetailsServiceImpl myAppUserDetailsService;	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		
		System.out.println("in configure");
		http.csrf().disable();
		http
		.authorizeRequests().anyRequest().authenticated()
		.antMatchers("**//*index*//**").hasAnyRole("Role_HR").and().formLogin().loginPage("/loginPage");
		*/

		/*http
		.authorizeRequests().anyRequest().authenticated()
		.antMatchers("/loginPage/**").permitAll()
		
		.and().formLogin().successForwardUrl("/index");*/
		/*.loginPage("/loginPage").successForwardUrl("/index");*//*.loginPage("/loginPage")*/
		/*.loginPage()*///login configuration
                /*.loginPage("/login").permitAll()
                .loginProcessingUrl("/app-login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/views/index")	
		.and().logout()    //logout configuration
		.logoutUrl("/app-logout") 
		.logoutSuccessUrl("/app/login")
		.and().exceptionHandling() //exception handling configuration
		.accessDeniedPage("/app/error");*/
	/*} 
        @Autowired
   	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
              auth.userDetailsService(myAppUserDetailsService);.passwordEncoder(passwordEncoder);
	}*/

}
