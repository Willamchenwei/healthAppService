package com.health.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "UserDetails")
public class UserDetails {
	@Id
	@GeneratedValue
	private int id;
	private Date detailsDate;
	private double fat;
	private double massIndex;/*身体质量系数*/
	private double fatRate;/*体脂率*/
	private double fatFreeMass;/*去脂体重*/
	private double boneMass;/*推定骨量*/
	private double moisture;/*水分*/
	@OneToOne (targetEntity = User.class)
	@JoinColumn (name = "userId", referencedColumnName = "id", unique = true)
	private User user;
	public UserDetails () {
		fat = 0;
		massIndex = 0;
		fatRate = 0;
		fatFreeMass = 0;
		boneMass = 0;
		moisture = 0;
		detailsDate = new Date();
	}
	
	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDetailsDate() {
		return detailsDate;
	}
	public void setDetailsDate(Date detailsDate) {
		this.detailsDate = detailsDate;
	}
	public double getMassIndex() {
		return massIndex;
	}
	public void setMassIndex(double massIndex) {
		this.massIndex = massIndex;
	}
	public double getFatRate() {
		return fatRate;
	}
	public void setFatRate(double fatRate) {
		this.fatRate = fatRate;
	}
	public double getFatFreeMass() {
		return fatFreeMass;
	}
	public void setFatFreeMass(double fatFreeMass) {
		this.fatFreeMass = fatFreeMass;
	}
	public double getBoneMass() {
		return boneMass;
	}
	public void setBoneMass(double boneMass) {
		this.boneMass = boneMass;
	}
	public double getMoisture() {
		return moisture;
	}
	public void setMoisture(double moisture) {
		this.moisture = moisture;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", detailsDate=" + detailsDate + ", fat=" + fat + ", massIndex=" + massIndex
				+ ", fatRate=" + fatRate + ", fatFreeMass=" + fatFreeMass + ", boneMass=" + boneMass + ", moisture="
				+ moisture + "]";
	}

}
