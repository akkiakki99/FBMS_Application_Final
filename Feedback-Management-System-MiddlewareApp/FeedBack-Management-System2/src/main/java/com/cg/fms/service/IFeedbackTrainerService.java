package com.cg.fms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.fms.model.FeedbackTrainerModel;
import com.cg.fms.entity.FeedbackTrainerEntity;
import com.cg.fms.exception.FMSException;


@Service
public interface IFeedbackTrainerService {
	FeedbackTrainerModel addFeedbackProgram(FeedbackTrainerModel fd) throws FMSException;
	FeedbackTrainerModel updateFeedbackProgram(FeedbackTrainerModel fd) throws  FMSException;
	List<FeedbackTrainerModel> viewAllFeedback() throws  FMSException;
	List<FeedbackTrainerEntity> viewFeedbackbyTrainerId(Long id);
	FeedbackTrainerModel getById(Long id) throws Exception;

}
