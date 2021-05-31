package com.cg.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.exception.FMSException;
import com.cg.fms.model.CourseModel;
import com.cg.fms.model.EmployeeModel;
import com.cg.fms.model.EnrolmentModel;
import com.cg.fms.repository.IParticipantRepository;

@Service
public class IParticipantService {

	@Autowired
	IParticipantRepository participantRepo;
	
	@Autowired
	private EMParser parser;

	public IParticipantService() {
		
	}

	public IParticipantService(IParticipantRepository participantRepo) {
		super();
		this.participantRepo = participantRepo;
		this.parser = new EMParser();
	}

	public EnrolmentModel enrollParticipant(EnrolmentModel enroll) throws FMSException {
		if(enroll != null) {
			if(participantRepo.existsById(enroll.getId())) {
				throw new FMSException(" with this Id already exists");
			}
		
		    enroll =  parser.parse(participantRepo.save(parser.parse(enroll))); 
		}
        
		return enroll;
	}

	public List<EmployeeModel> viewParticipantList(CourseModel course) {

		return participantRepo.viewParticipantList(course);
	}

	public EnrolmentModel getEmployeeIdByProgram(Long id) {
		return participantRepo.findByProgram(id);
	}

	public EnrolmentModel getEmployeeIdByEmployee(Long id) {
		return participantRepo.findByEmployee(id);
	}
}
