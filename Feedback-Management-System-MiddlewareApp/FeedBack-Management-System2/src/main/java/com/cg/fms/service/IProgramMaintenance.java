package com.cg.fms.service;

import java.util.List;

import com.cg.fms.model.ProgramModel;

public interface IProgramMaintenance {


	public boolean deleteProgram(long trainingId) throws Exception;
 
    public ProgramModel update(ProgramModel program) throws Exception;
	
	public ProgramModel getById(long i) throws Exception;

	public List<ProgramModel> getAll();

	public ProgramModel addProgram(ProgramModel program) throws Exception;

	List<ProgramModel> viewAllByDate(String sdate) throws Exception;

	List<ProgramModel> viewAllByFaculty(Long id);
}
