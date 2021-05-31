package com.cg.fms.model;

public class FeedbackProgramModel  {
	
	private Long FdprogramId;							//programId can't be null or empty
	private int clarity; 			//feedbackCriteria1 for the program
	private int technicality;			//feedbackCriteria2 for the program
	private int realworldapp;			//feedbackCriteria3 for the program
	private int interesting;			//feedbackCriteria4 for the program
	private int overallrating;			//feedbackCriteria5 for the program
	private String comments; 				// comments for the program
	private String suggestions;				//suggestions for the program
	private Long program;									//suggestion can't be empty or null

	public FeedbackProgramModel() {
		// default constructor
	}

		
	public FeedbackProgramModel(Long fdprogramId, int clarity, int technicality, int realworldapp, int interesting,
			int overallrating, String comments, String suggestions, Long program) {
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

	public Long getProgram() {
		return program;
	}

	public void setProgram(Long program) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((FdprogramId == null) ? 0 : FdprogramId.hashCode());
		result = prime * result + clarity;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + interesting;
		result = prime * result + overallrating;
		result = prime * result + ((program == null) ? 0 : program.hashCode());
		result = prime * result + realworldapp;
		result = prime * result + ((suggestions == null) ? 0 : suggestions.hashCode());
		result = prime * result + technicality;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FeedbackProgramModel other = (FeedbackProgramModel) obj;
		if (FdprogramId == null) {
			if (other.FdprogramId != null)
				return false;
		} else if (!FdprogramId.equals(other.FdprogramId))
			return false;
		if (clarity != other.clarity)
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (interesting != other.interesting)
			return false;
		if (overallrating != other.overallrating)
			return false;
		if (program == null) {
			if (other.program != null)
				return false;
		} else if (!program.equals(other.program))
			return false;
		if (realworldapp != other.realworldapp)
			return false;
		if (suggestions == null) {
			if (other.suggestions != null)
				return false;
		} else if (!suggestions.equals(other.suggestions))
			return false;
		if (technicality != other.technicality)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"FeedbackProgramModel [FdprogramId=%s, clarity=%s, technicality=%s, realworldapp=%s, interesting=%s, overallrating=%s, comments=%s, suggestions=%s, program=%s]",
				FdprogramId, clarity, technicality, realworldapp, interesting, overallrating, comments, suggestions,
				program);
	}
}

