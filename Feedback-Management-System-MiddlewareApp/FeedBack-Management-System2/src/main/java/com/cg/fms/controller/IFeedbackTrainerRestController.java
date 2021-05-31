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

import com.cg.fms.service.IFeedbackTrainerService;
import com.cg.fms.entity.FeedbackTrainerEntity;
import com.cg.fms.exception.FMSException;
import com.cg.fms.model.FeedbackTrainerModel;

@RestController
@RequestMapping("/FeedbackTrainer")
@CrossOrigin
public class IFeedbackTrainerRestController {

	@Autowired
	private IFeedbackTrainerService fts;

	/*
	 * to add a feedbackTrainer
	 * return : feedbackTrainer
	 * params : NIL
	 */
	
	//Function to add a new feedback record for any Trainer
	@PostMapping
	public ResponseEntity<FeedbackTrainerModel> addfeedbackTrainer(
			@RequestBody @Valid FeedbackTrainerModel ftm, BindingResult result) throws FMSException{

		return ResponseEntity.ok(fts.addFeedbackProgram(ftm));
	}

	/*
	 * to modify a feedbackTrainer
	 * return : feedbackTrainer
	 * params : NIL
	 */
	
	//Function to update a already exciting feedback for any Trainer
	@PutMapping("/{TrainerId}")
	public ResponseEntity<FeedbackTrainerModel> updateTrainerFeedback  (
			@RequestBody @Valid FeedbackTrainerModel ftm) throws FMSException {

		return ResponseEntity.ok(fts.updateFeedbackProgram(ftm));
	}

	/*
	 * to retrieve all feedbackTrainer
	 * return : List<feedbackTrainer>
	 * params : NIL
	 */

	//Function to display all the feedbacks in the database for all Trainers teaching
	@GetMapping
	public ResponseEntity<List<FeedbackTrainerModel>> getAll() throws FMSException{
		return ResponseEntity.ok(fts.viewAllFeedback());
	}

	@GetMapping("/list/{trainer}")
	public ResponseEntity<List<FeedbackTrainerEntity>> viewAllFbbyTrainerId(@PathVariable("trainer") Long id) throws FMSException
	{
		return ResponseEntity.ok(fts.viewFeedbackbyTrainerId(id));
	}
	
	@GetMapping("/{FdtrainerId}")
	public ResponseEntity<FeedbackTrainerModel> getById(@PathVariable("FdtrainerId") Long id) throws Exception {
		ResponseEntity<FeedbackTrainerModel> response = null;
		FeedbackTrainerModel feedprog = fts.getById(id);
		if (feedprog == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(feedprog, HttpStatus.OK);
		}
		return response;
	}
}

