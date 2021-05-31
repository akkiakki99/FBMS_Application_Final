
package com.cg.fms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.fms.entity.FeedbackProgramEntity;


@Repository
public interface FeedbackProgramRepo extends JpaRepository<FeedbackProgramEntity, Long> {

	@Query("Select f from FeedbackProgramEntity f where f.program.programId=?1")
	List<FeedbackProgramEntity> findbyProgramId(Long id);

}
