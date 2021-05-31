package com.cg.fms.service;

import com.cg.fms.entity.Employee;
import com.cg.fms.entity.Login;

public interface LoginInterface {
	
	public Employee validate(Login login);


}
