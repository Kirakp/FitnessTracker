package com.cg.ft.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class UserDiet {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userDietId;

    @OneToOne()
    @JoinColumn(name = "userId")
    private User userId;

    @ManyToOne()
    @JoinColumn(name = "dietId")
    private Diet dietId;

    private Integer no_of_days;

	public UserDiet() {
	}

	public UserDiet(User userId, Diet dietId, Integer no_of_days) {
		super();
		this.userId = userId;
		this.dietId = dietId;
		this.no_of_days = no_of_days;
	}

	public Integer getUserDietId() {
		return userDietId;
	}

	public void setUserDietId(Integer userDietId) {
		this.userDietId = userDietId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Diet getDietId() {
		return dietId;
	}

	public void setDietId(Diet dietId) {
		this.dietId = dietId;
	}

	public Integer getNo_of_days() {
		return no_of_days;
	}

	public void setNo_of_days(Integer no_of_days) {
		this.no_of_days = no_of_days;
	}

	@Override
	public String toString() {
		return "UserDiet [userDietId=" + userDietId + ", userId=" + userId + ", dietId=" + dietId + ", no_of_days="
				+ no_of_days + "]";
	}
}
