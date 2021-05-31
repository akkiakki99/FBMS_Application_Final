package com.cg.fms.model;

public class EnrolmentModel {
	
		int id;
		Long employee;
		Long program;
		
		
		public EnrolmentModel() {
			super();
			// TODO Auto-generated constructor stub
		}


		public EnrolmentModel(int id, Long employee, Long program) {
			super();
			this.id = id;
			this.employee = employee;
			this.program = program;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public Long getEmployee() {
			return employee;
		}


		public void setEmployee(Long employee) {
			this.employee = employee;
		}


		public Long getProgram() {
			return program;
		}


		public void setProgram(Long program) {
			this.program = program;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((employee == null) ? 0 : employee.hashCode());
			result = prime * result + id;
			result = prime * result + ((program == null) ? 0 : program.hashCode());
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
			EnrolmentModel other = (EnrolmentModel) obj;
			if (employee == null) {
				if (other.employee != null)
					return false;
			} else if (!employee.equals(other.employee))
				return false;
			if (id != other.id)
				return false;
			if (program == null) {
				if (other.program != null)
					return false;
			} else if (!program.equals(other.program))
				return false;
			return true;
		}


		@Override
		public String toString() {
			return String.format("EnrolmentModel [id=%s, employee=%s, program=%s]", id, employee, program);
		}
		
	}


