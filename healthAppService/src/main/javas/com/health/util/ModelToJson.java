package com.health.util;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.hibernate.impl.FetchingScrollableResultsImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import com.health.model.DynamicPicture;
import com.health.model.History;
import com.health.model.User;
import com.health.model.UserDetails;
import com.health.model.UserDynamic;

public class ModelToJson {
	public static String userToJson(User user) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Class cl = user.getClass();
		Field[] field = cl.getDeclaredFields();
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulate("code", 1);
		for (int i = 0; i < field.length - 2; i++) {
			field[i].setAccessible(true);
			try {
				if (field[i].getName().equals("userDetails")) {
					UserDetails userDetails = (UserDetails) field[i].get(user);
					if (userDetails != null) {
						jsonObject.accumulate("fat", userDetails.getFat());
						jsonObject.accumulate("fatRate", userDetails.getFatRate());
						jsonObject.accumulate("fatFreeMass", userDetails.getFatFreeMass());
						jsonObject.accumulate("boneMass", userDetails.getBoneMass());
						jsonObject.accumulate("moisture", userDetails.getMoisture());
						jsonObject.accumulate("massIndex", userDetails.getMassIndex());
					}
				}
				else if (field[i].getName().equals("userDate") && field[i].get(user) != null)
					jsonObject.accumulate(field[i].getName(), formatter.format(field[i].get(user)).toString());
				else if (field[i].getName().equals("userPassword"))
					;
				else
					jsonObject.accumulate(field[i].getName(), field[i].get(user));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return jsonObject.toString();
	}

	public static String objToJson(Object obj) {
		Class cl = obj.getClass();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Field[] field = cl.getDeclaredFields();
		JSONObject jsonObject = new JSONObject();
		for (int i = 0; i < field.length; i++) {
			field[i].setAccessible(true);
			try {
				jsonObject.accumulate(field[i].getName(), field[i].get(obj));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return jsonObject.toString();
	}

	public static String getJSONArray(List<History> history) {
		Iterator<History> it = history.iterator();
		JSONArray array = new JSONArray();
		JSONObject obj = new JSONObject();
		while (it.hasNext()) {
			History h = it.next();
			String str = objToJson(h);
			JSONObject json = new JSONObject(str);
			array.put(json);
		}
		obj.put("history", array);
		return obj.toString();
	}
	
	public static String getDynamicJson (List<UserDynamic> dyList) {
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		Iterator<UserDynamic> it = dyList.iterator();
		while (it.hasNext()) {
			int i = 1;
			UserDynamic userD = it.next();
			JSONObject obj = new JSONObject();
			obj.accumulate("dynamicDate", userD.getDynamicDate());
			obj.accumulate("dynamicInformation", userD.getDynamicInformation());
			JSONArray array = new JSONArray();
			List<DynamicPicture> piList = userD.getPictureList();
			Iterator<DynamicPicture> pit = piList.iterator();
			while (pit.hasNext()) {
				DynamicPicture pi = pit.next();
				JSONObject o = new JSONObject();
				o.accumulate("url" + i, pi.getPictureInformation());
				i ++;
				array.put(o);
			}
			obj.put("url", array);
			jsonArray.put(obj);
			
		}
		jsonObj.put("information", jsonArray);
		return jsonObj.toString();
	}

	@Test
	public void userToJs() {
		User user = new User();
		user.setId(1);
		user.setUserName("cghenwe");
		Class cl = user.getClass();

		Field[] field = cl.getDeclaredFields();

		JSONObject jsonObject = new JSONObject();
		for (int i = 0; i < field.length - 2; i++) {
			field[i].setAccessible(true);
			System.out.println(field[i].getName());
			try {
				jsonObject.accumulate(field[i].getName(), field[i].get(user));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println(jsonObject);
	}
}
