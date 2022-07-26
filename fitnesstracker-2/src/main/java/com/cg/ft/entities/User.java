package com.cg.ft.entities;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer userId;
	private String name;
	private String userName;
	private String password;
	private String contact;
	private Integer height;
	private Integer weight;
	private LocalDate dob;

@OneToMany
private List<UserActivity> userActivities=new ArrayList<UserActivity>();

	public User() {
	}

	public User(String name, String userName, String password, String contact, Integer height, Integer weight, LocalDate dob) {
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.contact = contact;
		this.height = height;
		this.weight = weight;
		this.dob = dob;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", name='" + name + '\'' +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", contact='" + contact + '\'' +
				", height=" + height +
				", weight=" + weight +
				", dob=" + dob +
				'}';
	}
}
