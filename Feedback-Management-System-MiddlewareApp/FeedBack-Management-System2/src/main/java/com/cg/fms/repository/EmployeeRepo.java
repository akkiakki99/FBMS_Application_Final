package com.cg.fms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.cg.fms.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	@Query("SELECT e FROM Employee e WHERE e.empSkill=?1")
	List<Employee> viewAllTrainers(String skill);


	List<Employee> findAllByEmployeeRole(String employeeRole);

}
