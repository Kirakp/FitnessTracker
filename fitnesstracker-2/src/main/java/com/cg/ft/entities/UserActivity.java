package com.cg.ft.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userActivity_id;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;

    @ManyToOne
    @JoinColumn(name="activityId")
    private Activity activityId;

    private Integer frequency;
    private Integer total_calories;
    private LocalDate start_date;

	public UserActivity() {
	}

	public UserActivity(User userId, Activity activityId, Integer frequency, Integer total_calories, LocalDate start_date) {
		super();
		this.userId = userId;
		this.activityId = activityId;
		this.frequency = frequency;
		this.total_calories = total_calories;
		this.start_date = start_date;
	}

	public Integer getUserActivity_id() {
		return userActivity_id;
	}
	public void setUserActivity_id(Integer userActivity_id) {
		this.userActivity_id = userActivity_id;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public Activity getActivityId() {
		return activityId;
	}
	public void setActivityId(Activity activityId) {
		this.activityId = activityId;
	}
	public Integer getFrequency() {
		return frequency;
	}
	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}
	public Integer getTotal_calories() {
		return total_calories;
	}
	public void setTotal_calories(Integer total_calories) {
		this.total_calories = total_calories;
	}
	public LocalDate getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}
	@Override
	public String toString() {
		return "UserActivity [userActivity_id=" + userActivity_id + ", userId=" + userId + ", activityId=" + activityId
				+ ", frequency=" + frequency + ", total_calories=" + total_calories + ", start_date=" + start_date
				+ "]";
	}
    
    
}
