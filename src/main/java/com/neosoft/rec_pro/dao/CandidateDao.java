package com.neosoft.rec_pro.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.neosoft.rec_pro.model.Candidate;
import com.neosoft.rec_pro.model.Technology;

/*@Repository*/
public interface CandidateDao extends JpaRepository<Candidate, Integer>
{
	
	@Transactional
	@Modifying
	@Query(value ="update candidate candidate set candidate.cv =:cv where candidate.candidate_id =:candidate_id",nativeQuery = true)
	public void updateCV(@Param("candidate_id")Integer candidate_id,@Param("cv") String cv);
	
	
	
	
	@Transactional
	@Modifying
	@Query(value ="update candidate candidate set candidate.first_name =:firstName, candidate.last_name =:lastName , candidate.experience =:experience , candidate.email_id =:emailId ,candidate.tech_id =:technology where candidate.candidate_id =:candidate_id",nativeQuery = true)
	public void updateCandidate(@Param("candidate_id")Integer candidate_id,@Param("firstName") String firstName,@Param("lastName") String lastName,@Param("experience") String experience,@Param("emailId") String emailId,@Param("technology") Technology tech);




	 Candidate findByEmailId(String emailId);
	
	
	
}
