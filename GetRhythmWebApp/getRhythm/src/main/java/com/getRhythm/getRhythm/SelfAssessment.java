package com.getRhythm.getRhythm;

import java.sql.Timestamp; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class

@Table(name = "self_assessment")
public class SelfAssessment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer assessmentID;
	
	@Column(nullable = false)
	private Integer userID;

	@Column(nullable = false)
	private String assessmentType;

	@Column(nullable = false)
	private Integer rating;

	@Column(nullable = false)
	private String comment;
	
	@Column(nullable = false)
	private Timestamp timeAndDate;
	
	@Column(nullable = true)
	private Integer score;

	public Integer getAssessmentID() {
		return assessmentID;
	}

	public void setAssessmentID(Integer assessmentID) {
		this.assessmentID = assessmentID;
	}

	public String getAssessmentType() {
		return assessmentType;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public void setAssessmentType(String assessmentType) {
		this.assessmentType = assessmentType;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}
	
	
	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getTimeAndDate() {
		return timeAndDate;
	}

	public void setTimeAndDate(Timestamp timeAndDate) {
		this.timeAndDate = timeAndDate;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
	
}
