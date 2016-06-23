package com.health.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import com.health.model.User;
import com.health.model.UserDynamic;

public class JsonToModel {
	public static User userJsonToUser (String userJsonstr) {
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
		User user = new User();
		JSONObject jsonObject = new JSONObject(userJsonstr);
		user.setId(jsonObject.getInt("id"));
		user.setUserName(jsonObject.getString("userName"));
		user.setUserPassword(jsonObject.getString("userPassword"));
		user.setHeadPortrait(jsonObject.getString("headPortrait"));
		user.setHeight(jsonObject.getDouble("height"));
		user.setSex(jsonObject.getString("sex"));
		Date date = null;
		try {
			date =  formatter.parse(jsonObject.getString("userDate"));
			
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setUserDate(date);
		user.setWeight(jsonObject.getDouble("weight"));
		return user;
	}
	public static UserDynamic jsonToDynamic (String json) {
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
		UserDynamic userDynamic = new UserDynamic();
		JSONObject jsonObject = new JSONObject(json);
		userDynamic.setDynamicInformation(jsonObject.getString("dynamicInformation"));
		userDynamic.setDynamicTitle(jsonObject.getString("dynamicTitle"));
		Date date = null;
		try {
			date = formatter.parse(jsonObject.getString("dynamicDate"));
		} catch (JSONException e) {
		} catch (ParseException e) {
		}
		userDynamic.setDynamicDate(date);
		return userDynamic;
	}
	@Test
	public void t () {
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
		String str = "1994-08-04";
		Date date = null;
		try {
			date = formatter.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user = new User();
		user.setId(4);
		user.setUserName("jkhdjs");
		user.setHeadPortrait("asdasffg");
		user.setUserPassword("123456");
		user.setHeight(2.0);
		user.setWeight(2.0);
		user.setSex("nan");
		user.setUserDate(date);
		String obj = ModelToJson.userToJson(user);
		User u = JsonToModel.userJsonToUser(obj);
		System.out.println(u);
	}
}
