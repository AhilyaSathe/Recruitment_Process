package com.neosoft.rec_pro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.neosoft.rec_pro.model.Candidate;
import com.neosoft.rec_pro.model.Department;
import com.neosoft.rec_pro.model.User;

public interface UserDao extends JpaRepository<User, Integer>
{
	@Query(value ="select * from user  where role ='HR'",nativeQuery = true)
	List<User> getHrList();

	/*@Query(value ="select * from interviewer  where  dept_id=:department" ,nativeQuery = true)
	List<User> getInterviewerList(@Param("department") Department department);
*/
}
