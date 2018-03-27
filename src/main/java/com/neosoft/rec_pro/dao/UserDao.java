package com.neosoft.rec_pro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neosoft.rec_pro.model.Candidate;
import com.neosoft.rec_pro.model.User;

public interface UserDao extends JpaRepository<User, Integer>
{
	@Query(value ="select * from user  where role ='HR'",nativeQuery = true)
	List<User> getHrList();

}
