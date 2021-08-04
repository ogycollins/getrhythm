package com.getRhythm.getRhythm;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity 
public class RhythmPatterns {
	
	@Id
	private int rhythmNo;

	private String soundImpl;

	private String animationImpl;

	private String rhythmBlock;

	private String rhythmSyllables;

	private Integer whichLessons;

	public int getRhythmNo() {
		return rhythmNo;
	}

	public void setRhythmNo(int rhythmNo) {
		this.rhythmNo = rhythmNo;
	}

	public String getSoundImpl() {
		return soundImpl;
	}

	public void setSoundImpl(String soundImpl) {
		this.soundImpl = soundImpl;
	}

	public String getAnimationImpl() {
		return animationImpl;
	}

	public void setAnimationImpl(String animationImpl) {
		this.animationImpl = animationImpl;
	}

	public String getRhythmBlock() {
		return rhythmBlock;
	}

	public void setRhythmBlock(String rhythmBlock) {
		this.rhythmBlock = rhythmBlock;
	}

	public String getRhythmSyllables() {
		return rhythmSyllables;
	}

	public void setRhythmSyllables(String rhythmSyllables) {
		this.rhythmSyllables = rhythmSyllables;
	}

	public Integer getWhichLessons() {
		return whichLessons;
	}

	public void setWhichLessons(Integer whichLessons) {
		this.whichLessons = whichLessons;
	}

}
