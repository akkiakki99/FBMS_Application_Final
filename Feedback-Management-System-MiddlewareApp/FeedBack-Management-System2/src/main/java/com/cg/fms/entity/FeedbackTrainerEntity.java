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
@Table(name = "fdtrainer")
public class FeedbackTrainerEntity implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="feedback_trainer_id")
	private Long FdtrainerId;			//primary key trainerId

	@Column(name = "technicalskills")
	private int technicalskills;		//feedback1 for trainer


	@Column(name = "clarityofspeech")
	private int clarityofspeech;		//feedback2 for trainer


	@Column(name = "communicationalskills")
	private int communicationalskills;		//feedback3 for trainer


	@Column(name = "friendliness")
	private int friendliness;		//feedback4 for trainer


	@Column(name = "overallrating")	//feedback5 for trainer
	private int overallrating;

	@Column(name = "comments")
	private String comments;			//comments for trainer


	@Column(name = "suggestions")
	private String suggestions;			//suggestions for the trainer

	@OneToOne(targetEntity = Employee.class)
	private Employee trainer;		//one to many mapping of trainer with employees

	
	public FeedbackTrainerEntity() {
		//default
	}

	
	public FeedbackTrainerEntity(Long fdtrainerId, int technicalskills, int clarityofspeech, int communicationalskills,
			int friendliness, int overallrating, String comments, String suggestions, Employee trainer) {
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

	public Employee getTrainer() {
		return trainer;
	}

	public void setTrainer(Employee trainer) {
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
	public String toString() {
		return String.format(
				"FeedbackTrainerEntity [FdtrainerId=%s, technicalskills=%s, clarityofspeech=%s, communicationalskills=%s, friendliness=%s, overallrating=%s, comments=%s, suggestions=%s, trainer=%s]",
				FdtrainerId, technicalskills, clarityofspeech, communicationalskills, friendliness, overallrating,
				comments, suggestions, trainer);
	}

}
