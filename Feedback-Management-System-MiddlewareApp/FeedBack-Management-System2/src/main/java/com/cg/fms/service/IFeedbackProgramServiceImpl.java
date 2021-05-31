package com.cg.fms.service;

import java.util.List;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.model.FeedbackProgramModel;
import com.cg.fms.repository.FeedbackProgramRepo;
import com.cg.fms.entity.FeedbackProgramEntity;
import com.cg.fms.exception.FMSException;

@Service
public class IFeedbackProgramServiceImpl implements IFeedbackProgramService {

	@Autowired
	FeedbackProgramRepo fp;

	@Autowired
	private EMParser parser;

	/*
	 * service implementation for add feedback Program
	 */
	
	@Transactional
	@Override
	public FeedbackProgramModel addFeedbackProgram(FeedbackProgramModel fd) throws FMSException {
		if (fd != null) {
			fd = parser.parse(fp.save(parser.parse(fd)));
			
		}
		return fd;}
	
	/*
	 * service implementation for update Feedback Program
	 */
	
	@Transactional
	@Override
	public FeedbackProgramModel updateFeedbackProgram(FeedbackProgramModel fd) throws FMSException {
		if (fd!= null) {
			if (!fp.existsById(fd.getFdprogramId())) {
				throw new FMSException("No Such Feedback");
			}

			fd = parser.parse(fp.save(parser.parse(fd)));
		}

		return fd;
	}
	
	/*
	 * service implementation for view all feedbacks
	 */
	
	@Override
	public List<FeedbackProgramModel> viewAllFeedback() throws FMSException {
		return fp.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}
	
	@Override
	public List<FeedbackProgramEntity> viewFeedbackbyProgramId(Long id)
	{
		return fp.findbyProgramId(id);
	}

	@Override
	public FeedbackProgramModel getById(Long id) throws Exception {
		if(!fp.existsById(id)) {
			throw new Exception("Feedback Not Found");
		}
		return parser.parse(fp.findById(id).get());
	}

}
