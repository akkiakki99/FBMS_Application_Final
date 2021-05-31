package com.cg.fms.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.fms.service.IFeedbackProgramService;
import com.cg.fms.entity.FeedbackProgramEntity;
import com.cg.fms.exception.FMSException;
import com.cg.fms.model.FeedbackProgramModel;


@RestController
@RequestMapping("/FeedbackProgram")
@CrossOrigin
public class IFeedbackProgramRestController {

	@Autowired
	private IFeedbackProgramService fps;
	
	/*
	 * to add a feedback
	 * return : feedback
	 * params : NIL
	 */
	
	//Function to add a new feedback record for any program
	@PostMapping
	public ResponseEntity<FeedbackProgramModel> addfeedbackProgram(
			@RequestBody @Valid FeedbackProgramModel fpm, BindingResult result) throws FMSException{


		return ResponseEntity.ok(fps.addFeedbackProgram(fpm));
	}
	
	/*
	 * to modify a feedback
	 * return : feedback
	 * params : NIL
	 */

	//Function to update a already exciting feedback for any program
	@PutMapping
	public ResponseEntity<FeedbackProgramModel> updateProgramFeedback  (
			@RequestBody @Valid FeedbackProgramModel fpm) throws FMSException {


		return ResponseEntity.ok(fps.updateFeedbackProgram(fpm));
	}
	
	/*
	 * to retrieve all feedback
	 * return : List<feedback>
	 * params : NIL
	 */

	//Function to display all the feedbacks in the database for all programs ongoing
	@GetMapping
	public ResponseEntity<List<FeedbackProgramModel>> getAll() throws FMSException{
		return ResponseEntity.ok(fps.viewAllFeedback());
	}

	/*
	 * to retrieve a feedback
	 * return : feedback
	 * params : Trainer Id
	 */

	@GetMapping("/list/{program}")
	public ResponseEntity<List<FeedbackProgramEntity>> viewAllFbbyProgramId(@PathVariable("program") Long id) throws FMSException
	{
		return ResponseEntity.ok(fps.viewFeedbackbyProgramId(id));
	}
	
	@GetMapping("/{FdprogramId}")
	public ResponseEntity<FeedbackProgramModel> getById(@PathVariable("FdprogramId") Long id) throws Exception {
		ResponseEntity<FeedbackProgramModel> response = null;
		FeedbackProgramModel feedprog = fps.getById(id);
		if (feedprog == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(feedprog, HttpStatus.OK);
		}
		return response;
	}
}

