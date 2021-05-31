package com.cg.fms.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "programs_master")
public class Program implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "program_id")
	private Long programId;				//primary key trainingId

	@Column(name = "start_date")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate startDate;		//start-date for the training

	@Column(name = "end_date")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate endDate;			//end date for the training

	@OneToOne(targetEntity = Course.class)
	private Course course;				//many to one mapping of course_id with course

	@OneToOne(targetEntity = Employee.class)
	private Employee trainer;		//many to one mapping of program_id with feedback

	public Program() {
		//no implementations default constructor
	}

	/* Parameterized Constructor*/
	

    /* getters and setters */
	public LocalDate getStartDate() {
		return startDate;
	}

	public Program(Long programId, LocalDate startDate, LocalDate endDate, Course course, Employee trainer) {
		super();
		this.programId = programId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.course = course;
		this.trainer = trainer;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Long getProgramId() {
		return programId;
	}
	
	public Employee getTrainer() {
		return trainer;
	}

	public void setTrainer(Employee trainer) {
		this.trainer = trainer;
	}

	@Override
	public String toString() {
		return String.format("trainingId=%s, startDate=%s, endDate=%s", programId,
				startDate, endDate);
	}

}