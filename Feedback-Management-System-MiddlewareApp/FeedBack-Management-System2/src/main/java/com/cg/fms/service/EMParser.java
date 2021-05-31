package com.cg.fms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entity.Course;
import com.cg.fms.entity.Employee;
import com.cg.fms.entity.Enrolment;
import com.cg.fms.entity.FeedbackProgramEntity;
import com.cg.fms.entity.FeedbackTrainerEntity;
import com.cg.fms.entity.Program;
import com.cg.fms.model.CourseModel;
import com.cg.fms.model.EmployeeModel;
import com.cg.fms.model.EnrolmentModel;
import com.cg.fms.model.FeedbackProgramModel;
import com.cg.fms.model.FeedbackTrainerModel;
import com.cg.fms.model.ProgramModel;
import com.cg.fms.repository.CourseRepo;
import com.cg.fms.repository.EmployeeRepo;
import com.cg.fms.repository.ProgramRepo;


@Service
public class EMParser {
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private ProgramRepo programRepo;
	
	@Autowired
	private EmployeeRepo employeeRepo;

	public CourseModel parse(Course source) {
		return source==null?null:
			new CourseModel(
					source.getCourseId(),
					source.getCourseName(), 
					source.getCourseDescription(), 
					source.getNoOfDays());
	}

	public Course parse(CourseModel source) {
		return source==null?null:
			new Course(
					source.getCourseId(),
					source.getCourseName(), 
					source.getCourseDescription(), 
					source.getNoOfDays());
	}


	public ProgramModel parse(Program source) {
		return source==null?null:
			new ProgramModel(
					source.getProgramId(),
					source.getStartDate(),
					source.getEndDate(),
					source.getCourse().getCourseId(),
					source.getTrainer().getEmployeeId());
	}


	public Program parse(ProgramModel source) {
		return source==null?null:
			new Program(
					source.getProgramId(),
					source.getStartDate(), 
					source.getEndDate(),
					courseRepo.findById(source.getCourse()).orElse(null),
			        employeeRepo.findById(source.getTrainer()).orElse(null));
	}

	public EmployeeModel parse(Employee source) {
		return source==null?null:
			new EmployeeModel( 
					source.getEmployeeId(),
					source.getEmployeeName(),  
					source.getEmployeePassword(),
					source.getEmployeeRole(),
					source.getEmpSkill());
	}

	public Employee parse(EmployeeModel source) {
		return source==null?null:
			new Employee(
					source.getEmployeeId(),
					source.getEmployeeName(),
					source.getEmployeePassword(),
					source.getEmployeeRole(),
					source.getEmpSkill());
	}
	
	public EnrolmentModel parse(Enrolment source) {
		return source == null?null:
			new EnrolmentModel(
					source.getId(),
					source.getEmployee().getEmployeeId(),
					source.getProgram().getProgramId());
	}
	
	public Enrolment parse(EnrolmentModel source) {
		return source == null?null:
			new Enrolment(
					source.getId(),
					employeeRepo.findById(source.getEmployee()).orElse(null),
					programRepo.findById(source.getProgram()).orElse(null));
	}


	public FeedbackTrainerEntity parse(FeedbackTrainerModel source) {
		return source==null?null:
			new FeedbackTrainerEntity(source.getFdtrainerId(), source.getTechnicalskills(), source.getClarityofspeech(), source.getCommunicationalskills(),
					source.getFriendliness(), source.getOverallrating(), source.getComments(), source.getSuggestions(), employeeRepo.findById(source.getTrainer()).orElse(null)); 
	}


	public FeedbackTrainerModel parse(FeedbackTrainerEntity source) {
		return source==null?null:
			new FeedbackTrainerModel(source.getFdtrainerId(), source.getTechnicalskills(), source.getClarityofspeech(), source.getCommunicationalskills(),
					source.getFriendliness(), source.getOverallrating(), source.getComments(), source.getSuggestions(),source.getTrainer().getEmployeeId()); 
	}




	public FeedbackProgramEntity parse(FeedbackProgramModel source) {
		return source==null?null:
			new FeedbackProgramEntity(source.getFdprogramId(), source.getClarity(), source.getTechnicality(), source.getRealworldapp(),
					source.getInteresting(), source.getOverallrating(), source.getComments(), source.getSuggestions(), programRepo.findById(source.getProgram()).orElse(null));
	}


	public FeedbackProgramModel parse(FeedbackProgramEntity source) {
		return source==null?null:
			new FeedbackProgramModel(source.getFdprogramId(), source.getClarity(), source.getTechnicality(), source.getRealworldapp(),
					source.getInteresting(), source.getOverallrating(), source.getComments(), source.getSuggestions(),source.getProgram().getProgramId());
	}

}
