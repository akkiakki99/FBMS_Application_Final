package com.cg.fms.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.exception.FMSException;
import com.cg.fms.model.CourseModel;
import com.cg.fms.repository.CourseRepo;

@Service
public class CourseMaintenanceService implements ICourseMaintenance {

	@Autowired
	private CourseRepo courseRepo;

	
	@Autowired
	private EMParser parser;
	
	/*
	 * A default Constructor with no implementation
	 */
	
	public CourseMaintenanceService() {

	}

	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */

	public CourseMaintenanceService(CourseRepo courseRepo) {
		super();
		this.courseRepo = courseRepo;
		this.parser = new EMParser();
	}

	/*
	 * service implementation for add course
	 */
	
	@Transactional
	@Override
	public CourseModel addCourse(CourseModel course) throws Exception {
		if(course != null) {
			if(courseRepo.existsById(course.getCourseId())) {
				throw new Exception("Course with this Id already exists");
			}

			course = parser.parse(courseRepo.save(parser.parse(course)));
		}

		return course;

	}

	@Transactional
	@Override
	public CourseModel getById(long l) throws Exception {
		if(!courseRepo.existsById(l))
			throw new Exception("No course found with this Id");

		return parser.parse(courseRepo.findById(l).get());
	}
	/*
	 * service implementation for finding  courseList
	 */
	@Transactional
	@Override
	public List<CourseModel> getAll() {
		return courseRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}

	@Override
	public boolean removeCourse(Long id) throws Exception {
		if(!courseRepo.existsById(id))
			throw new Exception("No course found with this Id");
		
		courseRepo.deleteById(id);
		
		return true;
	}

	@Transactional
	@Override
	public CourseModel updateCourse(CourseModel course ) throws FMSException {
		if (course!= null) {
			if (!courseRepo.existsById(course.getCourseId())) {
				throw new FMSException("No Such Course found");
			}

			course = parser.parse((courseRepo.save(parser.parse(course))));
		}

		return course;
	}

}
