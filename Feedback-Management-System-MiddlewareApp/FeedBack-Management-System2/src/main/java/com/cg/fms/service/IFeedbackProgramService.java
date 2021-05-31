package com.cg.fms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.fms.model.FeedbackProgramModel;
import com.cg.fms.entity.FeedbackProgramEntity;
import com.cg.fms.exception.FMSException;

@Service
public interface IFeedbackProgramService {
	FeedbackProgramModel addFeedbackProgram(FeedbackProgramModel fd) throws FMSException;
	FeedbackProgramModel updateFeedbackProgram(FeedbackProgramModel fd) throws  FMSException;
	List<FeedbackProgramModel> viewAllFeedback() throws  FMSException;
	List<FeedbackProgramEntity> viewFeedbackbyProgramId(Long id);
	FeedbackProgramModel getById(Long id) throws Exception;
}
