package com.getRhythm.getRhythm;

public class ExerciseActivityDetails {
	String activityName;
	boolean[] rhythmsIncluded= new boolean[7];
	Integer tempo;
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public boolean[] getRhythmsIncluded() {
		return rhythmsIncluded;
	}
	public void setRhythmsIncluded(boolean[] rhythmsIncluded) {
		this.rhythmsIncluded = rhythmsIncluded;
	}
	public Integer getTempo() {
		return tempo;
	}
	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}
	
	
}
