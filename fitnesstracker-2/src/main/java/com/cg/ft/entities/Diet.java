package com.cg.ft.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diet {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dietId;

    @OneToOne
    @JoinColumn(name="dietItemId")
    private DietItem dietItemId;

    private String dietType;


	public Diet() {
	}

	public Diet(DietItem dietItemId, String dietType) {
		super();
		this.dietItemId = dietItemId;
		this.dietType = dietType;
	}

	public Integer getDietId() {
		return dietId;
	}

	public void setDietId(Integer dietId) {
		this.dietId = dietId;
	}

	public DietItem getDietItemId() {
		return dietItemId;
	}

	public void setDietItemId(DietItem dietItemId) {
		this.dietItemId = dietItemId;
	}

	public String getDietType() {
		return dietType;
	}

	public void setDietType(String dietType) {
		this.dietType = dietType;
	}

	@Override
	public String toString() {
		return "Diet [dietId=" + dietId + ", dietItemId=" + dietItemId + ", dietType=" + dietType + "]";
	}

	
}
