package com.cg.fms.model;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EmployeeModel {


	private Long employeeId;

	@NotEmpty(message = "Employee name cannot be empty")
	@NotNull(message = "Employee name cannot be null")
	private String employeeName;						//employee name can't be empty can't be null

	@NotEmpty(message = "Password cannot be empty")
	@NotNull(message = "Password cannot be null")
	private String employeePassword;					//employee password can't be empty can't be null

	@NotEmpty(message = "Role cannot be empty")
	@NotNull(message = "Role cannot be null")
	private String employeeRole;						//employee role can't be empty can't be null

	@NotEmpty(message = "Skill cannot be empty")
	@NotNull(message = "Skill cannot be null")
	private String empSkill; 							//employee skill can't be empty can't be null 			

	public EmployeeModel() {
		/* Default Constructor */
	}

	public EmployeeModel(Long employeeId,
			@NotEmpty(message = "Employee name cannot be empty") @NotNull(message = "Employee name cannot be null") String employeeName,
			@NotEmpty(message = "Password cannot be empty") @NotNull(message = "Password cannot be null") String employeePassword,
			@NotEmpty(message = "Role cannot be empty") @NotNull(message = "Role cannot be null") String employeeRole,
			@NotEmpty(message = "Skill cannot be empty") @NotNull(message = "Skill cannot be null") String empSkill) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeePassword = employeePassword;
		this.employeeRole = employeeRole;
		this.empSkill = empSkill;
	}


	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	public String getEmpSkill() {
		return empSkill;
	}

	public void setEmpSkill(String empSkill) {
		this.empSkill = empSkill;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empSkill == null) ? 0 : empSkill.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result + ((employeePassword == null) ? 0 : employeePassword.hashCode());
		result = prime * result + ((employeeRole == null) ? 0 : employeeRole.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeModel other = (EmployeeModel) obj;
		if (empSkill == null) {
			if (other.empSkill != null)
				return false;
		} else if (!empSkill.equals(other.empSkill))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (employeePassword == null) {
			if (other.employeePassword != null)
				return false;
		} else if (!employeePassword.equals(other.employeePassword))
			return false;
		if (employeeRole == null) {
			if (other.employeeRole != null)
				return false;
		} else if (!employeeRole.equals(other.employeeRole))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"EmployeeModel [employeeId=%s, employeeName=%s, employeePassword=%s, employeeRole=%s, empSkill=%s, trainingId=%s, trainerId=%s]",
				employeeId, employeeName, employeePassword, employeeRole, empSkill);
	}

}
