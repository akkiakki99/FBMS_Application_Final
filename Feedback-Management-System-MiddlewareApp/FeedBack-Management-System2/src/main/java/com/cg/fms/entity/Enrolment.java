package com.cg.fms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enroll_master")
public class Enrolment implements Serializable{
	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "enroll_id")
		int id;
		
		@OneToOne(targetEntity = Employee.class)
		Employee employee;
		
		@OneToOne(targetEntity = Program.class)
		Program program;
		public Enrolment() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Enrolment(int id, Employee employee, Program program) {
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
		public Employee getEmployee() {
			return employee;
		}
		public void setEmployee(Employee employee) {
			this.employee = employee;
		}
		public Program getProgram() {
			return program;
		}
		public void setProgram(Program program) {
			this.program = program;
		}
		
		@Override
		public String toString() {
			return String.format("Enrolment [id=%s, employee=%s, program=%s]", id, employee, program);
		}

	}


