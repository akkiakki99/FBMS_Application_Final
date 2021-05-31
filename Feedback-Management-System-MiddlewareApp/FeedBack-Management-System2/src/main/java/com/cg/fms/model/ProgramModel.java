package com.cg.fms.model;

import java.io.Serializable;
import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


public class ProgramModel implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long programId;				//trainingId can be null

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate startDate;			//Date format should be standard

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate endDate;				//Date format should be standard
	
	private Long course;					//course id to be mapped

	private Long trainer;                //feedback id to be mapped

	
	public ProgramModel() {
		//no implementations default constructor
	}

    /*Parameterized Constructor*/
	
	public ProgramModel(Long programId, LocalDate startDate, LocalDate endDate, Long course, Long trainer) {
		super();
		this.programId = programId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.course = course;
		this.trainer = trainer;
	}

    // All getters and setters

	
	public LocalDate getStartDate() {
		return startDate;
	}


	public Long getProgramId() {
		return programId;
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

	public Long getCourse() {
		return course;
	}

	public void setCourse(Long course) {
		this.course = course;
	}


	public Long getTrainer() {
		return trainer;
	}

	public void setTrainer(Long trainer) {
		this.trainer = trainer;
	}

	

@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((trainer == null) ? 0 : trainer.hashCode());
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
		ProgramModel other = (ProgramModel) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (programId == null) {
			if (other.programId != null)
				return false;
		} else if (!programId.equals(other.programId))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (trainer == null) {
			if (other.trainer != null)
				return false;
		} else if (!trainer.equals(other.trainer))
			return false;
		return true;
	}

	//	to string override
	@Override
	public String toString() {
		return String.format("ProgramModel [trainingId=%s, startDate=%s, endDate=%s, course=%s, feedback=%s]",
				programId, startDate, endDate, course, trainer);
	}
    
   
	

}