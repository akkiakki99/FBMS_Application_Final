package com.cg.fms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entity.FeedbackTrainerEntity;
import com.cg.fms.exception.FMSException;
import com.cg.fms.model.FeedbackTrainerModel;
import com.cg.fms.repository.FeedbackTrainerRepo;

@Service
public class IFeedbackTrainerImpl implements IFeedbackTrainerService {

	@Autowired
	FeedbackTrainerRepo fp;

	@Autowired
	private EMParser parser;

	/*
	 * service implementation for add feedback program
	 */
	
	@Override
	public FeedbackTrainerModel addFeedbackProgram(FeedbackTrainerModel fd) throws FMSException {
		if (fd != null)

			fd = parser.parse(fp.save(parser.parse(fd)));

		return fd;
	}
	/*
	 * service implementation for update feedback program
	 */

	@Override
	public FeedbackTrainerModel updateFeedbackProgram(FeedbackTrainerModel fd) throws FMSException {
		if (fd!= null) {
			if (!fp.existsById(fd.getFdtrainerId())) {
				throw new FMSException("No Such Feedback");
			}

			fd = parser.parse(fp.save(parser.parse(fd)));
		}

		return fd;
	}
	
	/*
	 * service implementation for view all feedback list
	 */
	

	@Override
	public List<FeedbackTrainerModel> viewAllFeedback() throws FMSException {
		return fp.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}

	@Override
	public List<FeedbackTrainerEntity> viewFeedbackbyTrainerId (Long id)
	{
		return fp.findbyTrainerId(id);
	}

	@Override
	public FeedbackTrainerModel getById(Long id) throws Exception {
		if(!fp.existsById(id)) {
			throw new Exception("Feedback Not Found");
		}
		return parser.parse(fp.findById(id).get());
	}
}
