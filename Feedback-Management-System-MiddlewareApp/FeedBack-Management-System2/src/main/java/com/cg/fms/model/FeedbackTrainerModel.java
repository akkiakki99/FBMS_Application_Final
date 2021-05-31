package com.cg.fms.model;
public class FeedbackTrainerModel {


	private Long FdtrainerId;			//primary key trainerId
	private int technicalskills;		//feedback1 for trainer
	private int clarityofspeech;		//feedback2 for trainer
	private int communicationalskills;		//feedback3 for trainer
	private int friendliness;		//feedback4 for trainer
	private int overallrating;   //feedback5 for trainer
	private String comments;			//comments for trainer
	private String suggestions;			//suggestions for the trainer
	private Long trainer;		//one to many mapping of trainer with employees

	public FeedbackTrainerModel() {
		
	}

	
	public FeedbackTrainerModel(Long fdtrainerId, int technicalskills, int clarityofspeech, int communicationalskills,
			int friendliness, int overallrating, String comments, String suggestions, Long trainer) {
		super();
		FdtrainerId = fdtrainerId;
		this.technicalskills = technicalskills;
		this.clarityofspeech = clarityofspeech;
		this.communicationalskills = communicationalskills;
		this.friendliness = friendliness;
		this.overallrating = overallrating;
		this.comments = comments;
		this.suggestions = suggestions;
		this.trainer = trainer;
	}


	public Long getFdtrainerId() {
		return FdtrainerId;
	}


	public void setFdtrainerId(Long fdtrainerId) {
		FdtrainerId = fdtrainerId;
	}


	public int getTechnicalskills() {
		return technicalskills;
	}


	public void setTechnicalskills(int technicalskills) {
		this.technicalskills = technicalskills;
	}


	public int getClarityofspeech() {
		return clarityofspeech;
	}


	public void setClarityofspeech(int clarityofspeech) {
		this.clarityofspeech = clarityofspeech;
	}


	public int getCommunicationalskills() {
		return communicationalskills;
	}


	public void setCommunicationalskills(int communicationalskills) {
		this.communicationalskills = communicationalskills;
	}


	public int getFriendliness() {
		return friendliness;
	}


	public void setFriendliness(int friendliness) {
		this.friendliness = friendliness;
	}


	public int getOverallrating() {
		return overallrating;
	}


	public void setOverallrating(int overallrating) {
		this.overallrating = overallrating;
	}


	public Long getTrainer() {
		return trainer;
	}


	public void setTrainer(Long trainer) {
		this.trainer = trainer;
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
		result = prime * result + ((FdtrainerId == null) ? 0 : FdtrainerId.hashCode());
		result = prime * result + clarityofspeech;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + communicationalskills;
		result = prime * result + friendliness;
		result = prime * result + overallrating;
		result = prime * result + ((suggestions == null) ? 0 : suggestions.hashCode());
		result = prime * result + technicalskills;
		result = prime * result + ((trainer == null) ? 0 : trainer.hashCode());
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
		FeedbackTrainerModel other = (FeedbackTrainerModel) obj;
		if (FdtrainerId == null) {
			if (other.FdtrainerId != null)
				return false;
		} else if (!FdtrainerId.equals(other.FdtrainerId))
			return false;
		if (clarityofspeech != other.clarityofspeech)
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (communicationalskills != other.communicationalskills)
			return false;
		if (friendliness != other.friendliness)
			return false;
		if (overallrating != other.overallrating)
			return false;
		if (suggestions == null) {
			if (other.suggestions != null)
				return false;
		} else if (!suggestions.equals(other.suggestions))
			return false;
		if (technicalskills != other.technicalskills)
			return false;
		if (trainer == null) {
			if (other.trainer != null)
				return false;
		} else if (!trainer.equals(other.trainer))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return String.format(
				"FeedbackTrainerModel [FdtrainerId=%s, technicalskills=%s, clarityofspeech=%s, communicationalskills=%s, friendliness=%s, overallrating=%s, comments=%s, suggestions=%s, trainer=%s]",
				FdtrainerId, technicalskills, clarityofspeech, communicationalskills, friendliness, overallrating,
				comments, suggestions, trainer);
	}


}
