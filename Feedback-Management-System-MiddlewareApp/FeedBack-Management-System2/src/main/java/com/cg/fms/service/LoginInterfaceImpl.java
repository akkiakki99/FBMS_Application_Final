package com.cg.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entity.Employee;
import com.cg.fms.entity.Login;
import com.cg.fms.repository.EmployeeRepo;


@Service
public class LoginInterfaceImpl implements LoginInterface{

	@Autowired
	private EmployeeRepo eDao;

	@Override
	public Employee validate(Login login) {
		List<Employee> allEmployess = eDao.findAll();
		for (int i = 0; i < allEmployess.size(); i++) {
			if(allEmployess.get(i).getEmployeeName().equalsIgnoreCase(login.getEmployeeName()) && 
					allEmployess.get(i).getEmployeePassword().equalsIgnoreCase(login.getEmployeePassword())) {
				System.out.println(allEmployess.get(i));
				return allEmployess.get(i);
			}
		}
		return null;
	}
	

}
