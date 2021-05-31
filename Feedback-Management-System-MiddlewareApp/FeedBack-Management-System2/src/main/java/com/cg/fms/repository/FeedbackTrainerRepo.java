package com.cg.fms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.fms.entity.FeedbackTrainerEntity;


import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackTrainerRepo extends JpaRepository<FeedbackTrainerEntity , Long> {

	@Query("Select f from FeedbackTrainerEntity f where f.trainer.employeeId=?1")
	List<FeedbackTrainerEntity> findbyTrainerId(Long id);

}
