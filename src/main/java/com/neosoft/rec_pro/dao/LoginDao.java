package com.neosoft.rec_pro.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.neosoft.rec_pro.model.Department;
import com.neosoft.rec_pro.model.Technology;
import com.neosoft.rec_pro.model.User;

@Repository
public interface LoginDao  extends JpaRepository<User, Integer> 
{
	
	User findByUsernameAndPassword(String username,String password);
	
	/*@Transactional
	@Modifying*/
	@Query(value="select * from user u where u.dept_id =:department and u.role =:role",nativeQuery=true)
	public List<User> findByDepartment(@Param("department") Department department,@Param("role") String role);
}
