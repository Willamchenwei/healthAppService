package com.health.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DynamicPicture")
public class DynamicPicture {
	@Id
	@GeneratedValue
	private int id;
	private String pictureInformation;
	@ManyToOne (targetEntity = UserDynamic.class)
	@JoinColumn (name = "userDynamicId", referencedColumnName = "id", nullable = true)
	private UserDynamic userDynamic;
	public DynamicPicture () {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getPictureInformation() {
		return pictureInformation;
	}
	public void setPictureInformation(String pictureInformation) {
		this.pictureInformation = pictureInformation;
	}
	
	public UserDynamic getUserDynamic() {
		return userDynamic;
	}
	public void setUserDynamic(UserDynamic userDynamic) {
		this.userDynamic = userDynamic;
	}
	@Override
	public String toString() {
		return "DynamicPicture [id=" + id + ",  pictureInformation="
				+ pictureInformation + "]";
	}
	
}
