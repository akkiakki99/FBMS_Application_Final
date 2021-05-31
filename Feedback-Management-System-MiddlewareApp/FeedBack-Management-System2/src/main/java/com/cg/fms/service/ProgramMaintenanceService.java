package com.cg.fms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.fms.exception.FMSException;
import com.cg.fms.model.ProgramModel;
import com.cg.fms.repository.ProgramRepo;

@Service
public class ProgramMaintenanceService implements IProgramMaintenance{

	@Autowired
	private ProgramRepo programRepo;

	@Autowired
	private EMParser parser;

	public ProgramMaintenanceService() {

	}

	public ProgramMaintenanceService(ProgramRepo programRepo) {
		super();
		this.programRepo = programRepo;
		this.parser = new EMParser();
	}

	@Override
	@Transactional
	public ProgramModel addProgram(ProgramModel program) throws FMSException {
		if(program != null) {
			if(programRepo.existsById(program.getProgramId())) {
				throw new FMSException(" with this Id already exists");
			}

			program = parser.parse(programRepo.save(parser.parse(program)));
		}

		return program;
	}

	@Transactional
	@Override
	public boolean deleteProgram(long trainingId) throws FMSException {
		if(!programRepo.existsById(trainingId))
			throw new FMSException(" program with this Id does not exists");
		programRepo.deleteById(trainingId);

		return true;
	}

	@Override
	public ProgramModel getById(long i) throws FMSException {
		if(!programRepo.existsById(i))
			throw new FMSException("No program found with this Id");

		return parser.parse(programRepo.findById(i).get());
	}

	@Override
	public List<ProgramModel> getAll() {
		return programRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}

	@Override
	public ProgramModel update(ProgramModel program) throws FMSException {
		if (program!= null) {
			if (!programRepo.existsById(program.getProgramId())) {
				throw new FMSException("No Such Program found");
			}

			program = parser.parse((programRepo.save(parser.parse(program))));
		}

		return program;
	}

	@Override
	public List<ProgramModel> viewAllByDate(String sdate) throws Exception {
		LocalDate date= LocalDate.parse(sdate);
		return programRepo.findByStartDate(date);
	}
	
	@Override
	public List<ProgramModel> viewAllByFaculty(Long id)
	{
		return programRepo.findByEmployee(id);
	}

}
