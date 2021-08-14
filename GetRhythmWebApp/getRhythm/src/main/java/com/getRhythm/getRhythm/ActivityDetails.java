package com.getRhythm.getRhythm;

// A class to pass the details of an activity to the self-assessment page: previous activity, next activity and score if relevant
public class ActivityDetails {
	String activityName;
	Integer score;
	String nextActivity;
	
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getNextActivity() {
		return nextActivity;
	}
	public void setNextActivity(String nextActivity) {
		this.nextActivity = nextActivity;
	}
	
	
	

}
