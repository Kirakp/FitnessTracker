package com.cg.ft.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Admin {

	@Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer adminId;
    private String password;
    private Integer number;
    private String userName;

	public Admin() {
	}

	public Admin(String password, Integer number, String userName) {
		super();
		this.password = password;
		this.number = number;
		this.userName = userName;
	}

	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", password=" + password + ", number=" + number + ", userName=" + userName
				+ "]";
	}
    
    
}
