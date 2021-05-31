package com.cg.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.exception.FMSException;
import com.cg.fms.model.CourseModel;
import com.cg.fms.model.EmployeeModel;
import com.cg.fms.model.EnrolmentModel;
import com.cg.fms.service.IParticipantService;

@RestController
@RequestMapping("/enroll")
@CrossOrigin
public class IParticipantController {

	@Autowired
	IParticipantService serve;

	@PostMapping
	public EnrolmentModel enrollParticipant(@RequestBody EnrolmentModel enrol) throws FMSException {
		return serve.enrollParticipant(enrol);
	}

	@GetMapping("/list/{id}")
	public List<EmployeeModel> viewParticipantListByProgram(@PathVariable Long id) {
		CourseModel course = new CourseModel();
		course.setCourseId(id);
		return serve.viewParticipantList(course);
	}
	@GetMapping("/program/{program}")
	public ResponseEntity<EnrolmentModel> getEnrolByProgram(@PathVariable Long id) {
	    EnrolmentModel empId = serve.getEmployeeIdByProgram(id);
	    return ResponseEntity.ok(empId);
	}
	@GetMapping("/employee/{employee}")
	public ResponseEntity<EnrolmentModel> getEnrolByEmployee(@PathVariable Long id) {
	    EnrolmentModel empId = serve.getEmployeeIdByEmployee(id);
	    return ResponseEntity.ok(empId);
	}
}