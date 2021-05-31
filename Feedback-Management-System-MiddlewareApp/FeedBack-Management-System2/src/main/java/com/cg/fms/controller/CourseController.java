package com.cg.fms.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.model.CourseModel;
import com.cg.fms.service.ICourseMaintenance;

/* This is a course Controller*/
@RestController
@CrossOrigin
@RequestMapping(path="/course")
public class CourseController {

	@Autowired
	private ICourseMaintenance courseService;

	/*
	 * to retrieve all courses
	 * return : List<courses>
	 * params : NIL
	 */

	@GetMapping
	public ResponseEntity<List<CourseModel>> getAllCourse(){
		return ResponseEntity.ok(courseService.getAll());
	}


	/*
	 * to add a course
	 * return : course
	 * params : NIL
	 */

	@PostMapping
	public ResponseEntity<CourseModel> addCourse(@RequestBody @Valid CourseModel course ,BindingResult result) throws Exception {
		course = courseService.addCourse(course);
		return new ResponseEntity<>(course, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<CourseModel> updateCourse(@RequestBody CourseModel course) throws Exception {
	CourseModel course1 = courseService.updateCourse(course);
	return new ResponseEntity<>(course1, HttpStatus.OK);
	}

	/*
	 * to retrieve a course
	 * return : course
	 * params : course Id
	 */

	@GetMapping("/{courseId}")
	public ResponseEntity<CourseModel> findCourse(@PathVariable("courseId") Long id) throws Exception {
		ResponseEntity<CourseModel> response = null;
		CourseModel course = courseService.getById(id);
		if (course == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(course, HttpStatus.OK);
		}
		return response;
	}
	
	@DeleteMapping("/{courseId}")
	public ResponseEntity<Void> removeCourse(@PathVariable("courseId") Long id) throws Exception{
		ResponseEntity<Void> response = null;
		CourseModel course = courseService.getById(id);
		if (course == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			courseService.removeCourse(id);
			response = new ResponseEntity<>(HttpStatus.OK);
			
		}
		return response;
	}
}