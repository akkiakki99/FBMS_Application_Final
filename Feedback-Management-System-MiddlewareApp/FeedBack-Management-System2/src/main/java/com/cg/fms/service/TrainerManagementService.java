package com.cg.fms.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entity.Employee;
import com.cg.fms.exception.FMSException;
import com.cg.fms.model.EmployeeModel;
import com.cg.fms.repository.EmployeeRepo;

@Service
public class TrainerManagementService implements ITrainerManagement {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private EMParser parser;


	public TrainerManagementService(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
		this.parser = new EMParser();
	}
	
	/*
	 * service implementation for add Trainer
	 */

	@Transactional
	@Override
	public EmployeeModel addTrainer(EmployeeModel employeeMaster) throws Exception {
		if(employeeMaster != null) {
			if(employeeRepo.existsById(employeeMaster.getEmployeeId())) {
				throw new Exception("Employee with the given id already exists");
			}
			employeeMaster = parser.parse(employeeRepo.save(parser.parse(employeeMaster)));
		}
		return employeeMaster;
	}

	/*
	 * service implementation for employee by employeeId
	 */
	
	@Override
	public EmployeeModel getById(long id) throws Exception {
		if (!employeeRepo.existsById(id))
			throw new Exception("No Such Employee Found");

		return parser.parse(employeeRepo.findById(id).get());
	}

	/*
	 * service implementation for get list of all employee
	 */
	
	@Override
	public List<EmployeeModel> getAll() {
		return employeeRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}
	
	/*
	 * service implementation for removing employee
	 */

	@Transactional
	@Override
	public boolean removeEmployee(long employeeId) throws Exception {
		if (!employeeRepo.existsById(employeeId))
			throw new Exception("No Employee Found");

		employeeRepo.deleteById(employeeId);
		return true;
	}
	
	@Override
	public List<Employee> viewAllTrainersBySkills(String skill) throws Exception {
		List<Employee> employees = employeeRepo.viewAllTrainers(skill);
		if (employees.isEmpty()) {
			throw new Exception("Employee with these skills doesn't exist");
		} else {
			return employees;
		}
	}
	
	@Override
	public EmployeeModel update(EmployeeModel employee) throws FMSException {
		if (employee!= null) {
			if (!employeeRepo.existsById(employee.getEmployeeId())) {
				throw new FMSException("No Such Program found");
			}

			employee = parser.parse((employeeRepo.save(parser.parse(employee))));
		}

		return employee;
	}

	@Override
	public List<Employee> viewAllTrainersByRole(String employeeRole) throws Exception {
		List<Employee> employees = employeeRepo.findAllByEmployeeRole(employeeRole);
		if (employees.isEmpty()) {
			throw new Exception("Employee with these roles doesn't exist");
		} else {
			return employees;
		}
	}
}


