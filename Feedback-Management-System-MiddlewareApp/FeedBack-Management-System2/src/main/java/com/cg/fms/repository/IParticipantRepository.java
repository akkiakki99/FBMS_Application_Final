package com.cg.fms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cg.fms.entity.Enrolment;
import com.cg.fms.model.CourseModel;
import com.cg.fms.model.EmployeeModel;
import com.cg.fms.model.EnrolmentModel;


@Repository
public interface IParticipantRepository extends CrudRepository<Enrolment, Integer>

{
	
	@Query("Select e.employee from Enrolment e where e.program.course=?1")
	public List<EmployeeModel> viewParticipantList(CourseModel course);

	public EnrolmentModel findByProgram(Long id);

	public EnrolmentModel findByEmployee(Long id);
}
