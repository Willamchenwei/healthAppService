package com.health.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "History")
public class History {
	@Id
	@GeneratedValue
	private int id;
	private int userId;
	private double weight;
	private double fat;
	private Date historyDate;
	private double fatRate;/*体脂率*/
	private double fatFreeMass;/*去脂体重*/
	private double moisture;/*水分*/
	public History () {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Date getHistoryDate() {
		return historyDate;
	}
	public void setHistoryDate(Date historyDate) {
		this.historyDate = historyDate;
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
	public double getMoisture() {
		return moisture;
	}
	public void setMoisture(double moisture) {
		this.moisture = moisture;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "History [id=" + id + ", userId=" + userId + ", weight=" + weight + ", fat=" + fat + ", historyDate="
				+ historyDate + ", fatRate=" + fatRate + ", fatFreeMass=" + fatFreeMass + ", moisture=" + moisture
				+ "]";
	}
	
	
}
