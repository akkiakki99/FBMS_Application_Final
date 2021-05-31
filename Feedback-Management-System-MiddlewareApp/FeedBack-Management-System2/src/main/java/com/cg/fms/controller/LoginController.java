package com.cg.fms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.entity.Employee;
import com.cg.fms.entity.Login;
import com.cg.fms.service.LoginInterfaceImpl;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginInterfaceImpl service;

	@RequestMapping(value = "/validate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee validate(@RequestBody Login login) {
		Employee employee = service.validate(login);
		return employee;
	}

}
