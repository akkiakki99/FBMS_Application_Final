package com.cg.fms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Course Entity
@Entity
@Table(name = "courses_master")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "course_id")
	private Long courseId;  // primary key courseid

	@Column(name = "course_name")
	private String courseName;   // gives course name

	@Column(name = "course_description")
	private String courseDescription;  // gives course description

	@Column(name = "num_of_days")
	private int noOfDays;     // gives number of days


	public Course() {
		//no implementation default constructor
	}


	public Course(Long courseId, String courseName, String courseDescription, int noOfDays) {
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
	public String toString() {
		return String.format("Course [courseId=%s, courseName=%s, courseDescription=%s, noOfDays=%s]", courseId,
				courseName, courseDescription, noOfDays);
	}
}
