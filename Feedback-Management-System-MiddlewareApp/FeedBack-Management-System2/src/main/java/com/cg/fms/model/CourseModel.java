package com.cg.fms.model;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CourseModel {

	private Long courseId;

	@NotEmpty(message = "full name cannot be empty")
	@NotNull(message = "full name cannot be null")
	private String courseName;								//course name can't be empty can't be null

	@NotEmpty(message = "full name cannot be empty")
	@NotNull(message = "full name cannot be null")
	private String courseDescription;						//course description can't be empty can't be null

	@Min(value = 1, message="progran duration cannot be less than 1 day")
	@Max(value = 180, message = "progran duration cannot be more than 180 days")
	private int noOfDays;									//days can't be less than 1 not more than 180

	public CourseModel() {
		
	}

	
	public CourseModel(Long courseId,
			@NotEmpty(message = "full name cannot be empty") @NotNull(message = "full name cannot be null") String courseName,
			@NotEmpty(message = "full name cannot be empty") @NotNull(message = "full name cannot be null") String courseDescription,
			@Min(value = 1, message = "progran duration cannot be less than 1 day") @Max(value = 180, message = "progran duration cannot be more than 180 days") int noOfDays) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.noOfDays = noOfDays;
	}


	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}


	public Long getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseDescription == null) ? 0 : courseDescription.hashCode());
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + noOfDays;
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
		CourseModel other = (CourseModel) obj;
		if (courseDescription == null) {
			if (other.courseDescription != null)
				return false;
		} else if (!courseDescription.equals(other.courseDescription))
			return false;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (noOfDays != other.noOfDays)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Course [courseId=%s, courseName=%s, courseDescription=%s, noOfDays=%s]", courseId,
				courseName, courseDescription, noOfDays);
	}


}
