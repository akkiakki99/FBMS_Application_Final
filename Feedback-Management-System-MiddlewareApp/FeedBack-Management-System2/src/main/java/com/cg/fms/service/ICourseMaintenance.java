package com.cg.fms.service;

import java.util.List;

import com.cg.fms.exception.FMSException;
import com.cg.fms.model.CourseModel;

public interface ICourseMaintenance {

	public CourseModel addCourse(CourseModel course) throws Exception;
    public boolean removeCourse(Long id) throws Exception;
	public CourseModel getById(long l) throws Exception;
	public List<CourseModel> getAll();
	public CourseModel updateCourse(CourseModel course) throws FMSException;
}
