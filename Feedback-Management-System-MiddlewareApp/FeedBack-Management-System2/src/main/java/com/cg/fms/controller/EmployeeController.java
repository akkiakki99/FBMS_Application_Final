package com.cg.fms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.entity.Employee;
import com.cg.fms.model.EmployeeModel;
import com.cg.fms.service.ITrainerManagement;


@RestController
@CrossOrigin
@RequestMapping(path="/admin")
public class EmployeeController {

	@Autowired
	private ITrainerManagement employeerepository;

	/*
	 * to retrieve all customer
	 * return : List<customer>
	 * params : NIL
	 */

	//get employee detail
	@GetMapping
	public ResponseEntity<List<EmployeeModel>> getEmployeeDetails() throws Exception{
		return new ResponseEntity<>(employeerepository.getAll(), HttpStatus.OK);
	}

	/*
	 * to add a customer
	 * return : customer
	 * params : NIL
	 */

	@PostMapping
	public ResponseEntity<EmployeeModel> addTrainer(@RequestBody @Valid EmployeeModel employee, BindingResult result) throws Exception {
		employee = employeerepository.addTrainer(employee);
		return new ResponseEntity<>(employee, HttpStatus.CREATED);

	}
	/*
	 * to delete a customer
	 * return : void
	 * params : customer Id
	 */

	@DeleteMapping("/{employeeId}")
	public ResponseEntity<Void> removeEmployee(@PathVariable("employeeId") Long id) throws Exception{
		ResponseEntity<Void> response = null;
		EmployeeModel employee = employeerepository.getById(id);
		if (employee == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			employeerepository.removeEmployee(id);
			response = new ResponseEntity<>(HttpStatus.OK);
			
		}
		return response;
	}

	/*
	 * to retrieve a customer
	 * return : customer
	 * params : customer Id
	 */


	@GetMapping("/{employeeId}")
	public ResponseEntity<EmployeeModel> findEmployee(@PathVariable("employeeId") Long id) throws Exception {
		ResponseEntity<EmployeeModel> response = null;
		EmployeeModel employee = employeerepository.getById(id);
		if (employee == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(employee, HttpStatus.OK);
		}
		return response;
	}
	
	@PutMapping
	public ResponseEntity<EmployeeModel> updateProgram(@RequestBody @Valid EmployeeModel employee) throws Exception {
		return ResponseEntity.ok((employeerepository.update(employee)));
	}
	
	@GetMapping("/skills/{empSkill}")
	// mapping the method to get the list of trainers with specific skill set
	public ResponseEntity<List<Employee>> viewAllTrainersBySkills(@PathVariable("empSkill") String skill)
			throws Exception {
		List<Employee> elist = employeerepository.viewAllTrainersBySkills(skill);
		ResponseEntity<List<Employee>> response = new ResponseEntity<List<Employee>>(elist, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/role/{employeeRole}")
	// mapping the method to get the list of trainers with specific skill set
	public ResponseEntity<List<Employee>> viewAllTrainersByRole(@PathVariable("employeeRole") String role)
			throws Exception {
		List<Employee> elist = employeerepository.viewAllTrainersByRole(role);
		ResponseEntity<List<Employee>> response = new ResponseEntity<List<Employee>>(elist, HttpStatus.OK);
		return response;
	}
} 
