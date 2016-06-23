package com.health.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "PhysicalCondition")
public class PhysicalCondition {
	@Id
	@GeneratedValue
	private int id;
	private int bodyType;
	private String typeName;
	@ManyToOne (targetEntity = User.class)
	@JoinColumn (name = "userId", referencedColumnName = "id", nullable = true)
	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBodyType() {
		return bodyType;
	}
	public void setBodyType(int bodyType) {
		this.bodyType = bodyType;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "PhysicalCondition [id=" + id + ", bodyType=" + bodyType + ", typeName=" + typeName + "]";
	}
}
