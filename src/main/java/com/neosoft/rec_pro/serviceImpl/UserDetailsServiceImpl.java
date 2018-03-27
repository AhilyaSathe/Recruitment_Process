package com.neosoft.rec_pro.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
import org.springframework.stereotype.Service;

import com.neosoft.rec_pro.dao.LoginDao;
import com.neosoft.rec_pro.model.User;

@Service
public class UserDetailsServiceImpl /*implements UserDetailsService*/
{
	@Autowired
	LoginDao loginDao;
	
	
	//@Override
	public User loadUserByUsername(String username,String password)/*throws UsernameNotFoundException*/ 
	{
		System.out.println("in loadUserByUsername");
		User user=loginDao.findByUsernameAndPassword(username,password);
		/*Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        
            grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));*/
        
return user;
       /* return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);*/
		
	}

}
