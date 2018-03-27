package com.neosoft.rec_pro.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.neosoft.rec_pro.model.FinalSelectionStatus;
import com.neosoft.rec_pro.model.ScheduleInterviews;
import com.neosoft.rec_pro.model.Technology;

public interface ScheduleInterviewDao extends JpaRepository<ScheduleInterviews,Integer>
{

	@Transactional
	@Modifying
	@Query(value ="update schedule_interviews scheduleInterviews set scheduleInterviews.scheduled_status ='select'  where scheduleInterviews.scheduled_id =:scheduled_id",nativeQuery = true)
	public void updateAcceptedStatus(@Param("scheduled_id")Integer scheduled_id);
	
	/*@Transactional
	@Modifying*/
	@Query(value ="select scheduled_status from schedule_interviews scheduleInterviews  where scheduleInterviews.scheduled_id =:scheduled_id",nativeQuery = true)
	public boolean getScheduledStatus(@Param("scheduled_id")Integer scheduled_id);

	@Transactional
	@Modifying
	@Query(value ="update schedule_interviews scheduleInterviews set scheduleInterviews.scheduled_status ='reject' where scheduleInterviews.scheduled_id =:scheduled_id",nativeQuery = true)
	public void getRejectedStatus(@Param("scheduled_id") Integer scheduledId);
	/*,@Param("reject")Enum<FinalSelectionStatus> reject*/
	

	@Query(value ="select scheduled_status from schedule_interviews scheduleInterviews  where scheduleInterviews.candidate_Id =:cand_id",nativeQuery = true)
	public String getScheduledStatusOfCandidate(@Param("cand_id")Integer cand_id);

}
