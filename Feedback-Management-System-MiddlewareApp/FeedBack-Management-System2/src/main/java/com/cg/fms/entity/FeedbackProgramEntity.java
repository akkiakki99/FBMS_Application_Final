package com.cg.fms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fdprogram")
public class FeedbackProgramEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="feedback_program_id")
	private Long FdprogramId;				//primary key ProgramID

	@Column(name = "clarity")
	private int clarity; 			//feedbackCriteria1 for the program


	@Column(name = "technicality")
	private int technicality;			//feedbackCriteria2 for the program


	@Column(name = "realworldapp")
	private int realworldapp;			//feedbackCriteria3 for the program


	@Column(name = "interesting")
	private int interesting;			//feedbackCriteria4 for the program


	@Column(name = "overallrating")
	private int overallrating;			//feedbackCriteria5 for the program


	@Column(name = "comments")
	private String comments; 				// comments for the program


	@Column(name = "suggestions")
	private String suggestions;				//suggestions for the program

	@OneToOne(targetEntity = Program.class)
	private Program program;			    //one to one mapping of feedback with programs

	public FeedbackProgramEntity() {
		// default
	}

	public FeedbackProgramEntity(Long fdprogramId, int clarity, int technicality, int realworldapp, int interesting,
			int overallrating, String comments, String suggestions, Program program) {
		super();
		FdprogramId = fdprogramId;
		this.clarity = clarity;
		this.technicality = technicality;
		this.realworldapp = realworldapp;
		this.interesting = interesting;
		this.overallrating = overallrating;
		this.comments = comments;
		this.suggestions = suggestions;
		this.program = program;
	}

	public Long getFdprogramId() {
		return FdprogramId;
	}

	public void setFdprogramId(Long fdprogramId) {
		FdprogramId = fdprogramId;
	}

	public int getClarity() {
		return clarity;
	}

	public void setClarity(int clarity) {
		this.clarity = clarity;
	}

	public int getTechnicality() {
		return technicality;
	}

	public void setTechnicality(int technicality) {
		this.technicality = technicality;
	}

	public int getRealworldapp() {
		return realworldapp;
	}

	public void setRealworldapp(int realworldapp) {
		this.realworldapp = realworldapp;
	}

	public int getInteresting() {
		return interesting;
	}

	public void setInteresting(int interesting) {
		this.interesting = interesting;
	}

	public int getOverallrating() {
		return overallrating;
	}

	public void setOverallrating(int overallrating) {
		this.overallrating = overallrating;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public String getSuggestions() {
		return suggestions;
	}


	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}



	public Program getPrograms() {
		return program;
	}


	public void setPrograms(Program program) {
		this.program = program;
	}

	@Override
	public String toString() {
		return String.format(
				"FeedbackProgramEntity [FdprogramId=%s, clarity=%s, technicality=%s, realworldapp=%s, interesting=%s, overallrating=%s, comments=%s, suggestions=%s, program=%s]",
				FdprogramId, clarity, technicality, realworldapp, interesting, overallrating, comments, suggestions,
				program);
	}
}

