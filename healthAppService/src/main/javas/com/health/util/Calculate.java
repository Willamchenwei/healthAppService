package com.health.util;

import java.text.DecimalFormat;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.health.model.User;
import com.health.model.UserDetails;

@Component
public class Calculate {
	private User user;
	public void setUser (User user) {
		this.user = user;
	}
	public User calculateUserDetail () {
		DecimalFormat    df   = new DecimalFormat("######0.00");   
		UserDetails userDetails = new UserDetails();
		userDetails.setBoneMass(Double.parseDouble(df.format(calculateBoneMass())));
		userDetails.setFatFreeMass(Double.parseDouble(df.format(calculateFatFreeMass())));
		userDetails.setFatRate(Double.parseDouble(df.format(calculateFatRate())));
		userDetails.setMassIndex(Double.parseDouble(df.format(calculateMassIndex())));
		userDetails.setMoisture(Double.parseDouble(df.format(calculateMoisture())));
		userDetails.setFat(Double.parseDouble(df.format(calculateFat())));
		user.setUserDetails(userDetails);
		return user;
	}
	public double calculateFat () {
		return user.getWeight() * calculateFatRate() / 100;
	}
	public double calculateMassIndex () {
		if (user.getHeight() != 0) 
			return user.getWeight() / (user.getHeight() * user.getHeight());
		return 0;
	}
	public double calculateFatRate () {
		return 1.2 * calculateMassIndex() + 0.23 * 20 - 5.4 - 10.8 * (user.getSex().equals("男") ? 1: 0);
	}
	public double calculateFatFreeMass () {
		return user.getWeight() -  user.getWeight() * calculateFatRate() / 100;
	}
	public double calculateBoneMass () {
		if (user.getSex().equals("男")){
			if (user.getWeight() <= 60)
				return 2.5;
			else if (user.getWeight() >= 75)
				return 3.2;
			else
				return 2.9;
		}
		else {
			if (user.getWeight() <= 45)
				return 1.8;
			else if (user.getWeight() >= 75)
				return 2.5;
			else
				return 2.2;
		}
	}
	public double calculateMoisture () {
		return 9 * calculateBoneMass();
	}
}
