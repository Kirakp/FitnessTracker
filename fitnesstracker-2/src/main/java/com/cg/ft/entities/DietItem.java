package com.cg.ft.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DietItem {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dietItemId;

	private String breakfast;
	private String brunch;
	private String lunch;
	private String snack;
	private String dinner;


	public DietItem() {
	}

	public DietItem(String breakfast, String brunch, String lunch, String snack, String dinner) {
		this.breakfast = breakfast;
		this.brunch = brunch;
		this.lunch = lunch;
		this.snack = snack;
		this.dinner = dinner;
	}

	public Integer getDietItemId() {
		return dietItemId;
	}

	public void setDietItemId(Integer dietItemId) {
		this.dietItemId = dietItemId;
	}

	public String getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}

	public String getBrunch() {
		return brunch;
	}

	public void setBrunch(String brunch) {
		this.brunch = brunch;
	}

	public String getLunch() {
		return lunch;
	}

	public void setLunch(String lunch) {
		this.lunch = lunch;
	}

	public String getSnack() {
		return snack;
	}

	public void setSnack(String snack) {
		this.snack = snack;
	}

	public String getDinner() {
		return dinner;
	}

	public void setDinner(String dinner) {
		this.dinner = dinner;
	}

	@Override
	public String toString() {
		return "DietItem{" +
				"dietItemId=" + dietItemId +
				", breakfast='" + breakfast + '\'' +
				", brunch='" + brunch + '\'' +
				", lunch='" + lunch + '\'' +
				", snack='" + snack + '\'' +
				", dinner='" + dinner + '\'' +
				'}';
	}
}
