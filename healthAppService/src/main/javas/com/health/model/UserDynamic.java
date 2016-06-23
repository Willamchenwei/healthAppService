package com.health.model;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "UserDynamic")
public class UserDynamic {
	@Id
	@GeneratedValue
	private int id;
	private String dynamicTitle;
	private String dynamicInformation;
	private Date dynamicDate;
	@ManyToOne (targetEntity = User.class)
	@JoinColumn (name = "userId", referencedColumnName = "id", nullable = true)
	private User user;
	@OneToMany (targetEntity = DynamicPicture.class, mappedBy = "userDynamic")
	private List<DynamicPicture> pictureList = new ArrayList<DynamicPicture>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDynamicTitle() {
		return dynamicTitle;
	}
	public void setDynamicTitle(String dynamicTitle) {
		this.dynamicTitle = dynamicTitle;
	}
	public String getDynamicInformation() {
		return dynamicInformation;
	}
	public void setDynamicInformation(String dynamicInformation) {
		this.dynamicInformation = dynamicInformation;
	}

	public Date getDynamicDate() {
		return dynamicDate;
	}
	public void setDynamicDate(Date dynamicDate) {
		this.dynamicDate = dynamicDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<DynamicPicture> getPictureList() {
		return pictureList;
	}
	public void setPictureList(List<DynamicPicture> pictureList) {
		this.pictureList = pictureList;
	}
	@Override
	public String toString() {
		return "UserDynamic [id=" + id + ", dynamicTitle=" + dynamicTitle + ", dynamicInformation=" + dynamicInformation
				+ ", dynamicDate=" + dynamicDate + ", pictureList=" + pictureList + "]";
	}
	

	
	
}
