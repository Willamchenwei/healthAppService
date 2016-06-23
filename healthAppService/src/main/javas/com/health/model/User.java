package com.health.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table (name = "User")
public class User {
	@Id
	@GeneratedValue
	private int id;
	private String userName;
	private String nickName;
	private String userPassword;
	private String headPortrait;
	private String sex;
	private double height ;
	private double weight;
	private Date userDate;
	@OneToOne (targetEntity = UserDetails.class, mappedBy="user", fetch=FetchType.EAGER)
	private UserDetails userDetails;
	@OneToMany (targetEntity = UserDynamic.class, mappedBy = "user")
	private List<UserDynamic> userDynamic = new LinkedList<UserDynamic>();
	@OneToMany (targetEntity = PhysicalCondition.class, mappedBy = "user")
	private List<PhysicalCondition> physicalCondition = new ArrayList<PhysicalCondition>();
	public User () {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getUserDate() {
		return userDate;
	}
	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public List<UserDynamic> getUserDynamic() {
		return userDynamic;
	}
	public void setUserDynamic(List<UserDynamic> userDynamic) {
		this.userDynamic = userDynamic;
	}
	public List<PhysicalCondition> getPhysicalCondition() {
		return physicalCondition;
	}
	public void setPhysicalCondition(List<PhysicalCondition> physicalCondition) {
		this.physicalCondition = physicalCondition;
	}
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", nickName=" + nickName + ", userPassword=" + userPassword
				+ ", headPortrait=" + headPortrait + ", sex=" + sex + ", height=" + height + ", weight=" + weight
				+ ", userDate=" + userDate + ", userDetails=" + userDetails + ", userDynamic=" + userDynamic
				+ ", physicalCondition=" + physicalCondition + "]";
	}
	
}
