package com.cg.fms.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.fms.entity.Program;
import com.cg.fms.model.ProgramModel;

@Repository
public interface ProgramRepo extends JpaRepository<Program, Long> {

	@Query("Select p from Program p where p.startDate=?1")
	List<ProgramModel> findByStartDate(LocalDate date);

	@Query("Select p from Program p where p.trainer.employeeId=?1")
	List<ProgramModel> findByEmployee(Long id);


}
