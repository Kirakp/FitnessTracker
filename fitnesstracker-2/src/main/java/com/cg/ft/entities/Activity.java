package com.cg.ft.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Activity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activityId;
    private String activityName;
    private Float duration;
    private Float calories;

	public Activity() {
	}

	public Activity(String activityName, Float duration, Float calories) {
		super();
		this.activityName = activityName;
		this.duration = duration;
		this.calories = calories;
	}

	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public Float getDuration() {
		return duration;
	}
	public void setDuration(Float duration) {
		this.duration = duration;
	}
	public Float getCalories() {
		return calories;
	}
	public void setCalories(Float calories) {
		this.calories = calories;
	}
	@Override
	public String toString() {
		return "Activity [activityId=" + activityId + ", activityName=" + activityName + ", duration=" + duration
				+ ", calories=" + calories + "]";
	}
    
    
}
