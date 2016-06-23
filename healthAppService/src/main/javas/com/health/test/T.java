package com.health.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.health.model.DynamicPicture;
import com.health.model.History;
import com.health.model.PhysicalCondition;
import com.health.model.User;
import com.health.model.UserDetails;
import com.health.model.UserDynamic;
import com.health.service.impl.DynamicPictureService;
import com.health.service.impl.HistoryService;
import com.health.service.impl.UserService;
import com.health.util.Calculate;
import com.health.util.GetBodyCondition;
import com.health.util.ModelToJson;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:applicationContext.xml"})
public class T {
	@Resource
	private UserService userService;
	@Resource
	private Calculate calculate ;
	@Resource
	private HistoryService historyService;
	@Resource
	private DynamicPictureService picture;
	@Test
	public void t () {
		//ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
	//	SessionFactory s = app.getBean("sessionFactory", SessionFactory.class);
		//Session session = s.openSession();
		//ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
	//	Transaction ts=session.beginTransaction();
/*		DynamicPicture dy = new DynamicPicture();
		dy.setUserDynamicId(1);
		dy.setPictureInformation("asjkdhkjdf");
		picture.save(dy);*/
		/*User user = new User ();
		
		user.setUserName("wei");
		user.setUserPassword("wei");
		user.setSex("男");
		user.setHeight(1.75);
		user.setWeight(80);
		calculate.setUser(user);
		User u = calculate.calculateUserDetail();
		userService.addorUpdataUser(u);
		//System.out.println(u);
		History history = new History();
		history.setUserId(u.getId());
		history.setFatFreeMass(u.getUserDetails().getFatFreeMass());
		history.setFatRate(u.getUserDetails().getFatRate());
		history.setWeight(u.getWeight());
		history.setMoisture(u.getUserDetails().getMoisture());
		history.setHistoryDate(u.getUserDate());
		historyService.addorUpdataHistory(history);*/
		
	//	u.getUserDetails().setId(id);
	//	u.setSex("");
	//	userService.addorUpdataUser(user);
		//session.saveOrUpdate(user);
		
		//ts.commit();
		//session.close();
/*	User user = new User();
	
		user.setUserName("chenwei");
		user.setUserPassword("963205");
		user.setHeight(1.75);
		user.setWeight(70);
		user.setSex("男");
		
		
		UserDynamic userDynamic = new UserDynamic();
		userDynamic.setUser(user);
		userDynamic.setDynamicInformation("chenweihenliubi");
		DynamicPicture d = new DynamicPicture();
		d.setPictureInformation("sajdhjs");
		List<DynamicPicture> p = new ArrayList<>();
		p.add(d);
		userDynamic.setPictureList(p);
		List<UserDynamic> list = new LinkedList<UserDynamic>();
		list.add(userDynamic);
		user.setUserDynamic(list);
		userService.addorUpdataUser(user);*/
/*		UserDetails userDetails = new UserDetails();
		userDetails.setId(1);
		userDetails.setMassIndex(2.0);
		user.setUserDetails(userDetails);
		userService.addorUpdataUser(user);*/
		/*use.setUser(user);
		User u = use.calculateUserDetail();
		System.out.println(u);
		get.setUser(u);
		List<PhysicalCondition> list = get.getBodyCodition();
		System.out.println(list);*/
	/*	User user = userService.getUser(6);
	//	System.out.println(user);
		String str = ModelToJson.getDynamicJson(user.getUserDynamic());
		System.out.println (str);
		JSONObject obj = new JSONObject(str);
		JSONArray array = obj.getJSONArray("information");
		//System.out.println(array);
		JSONObject o = array.getJSONObject(0);
		System.out.println(o);*/
	/*	History history = new History();
		history.setFat(30);
		history.setFatFreeMass(30);
		history.setFatRate(30);
		history.setMoisture(30);
		history.setWeight(80);
		history.setUserId(6);
		historyService.addorUpdataHistory(history);*/
		List<History> l = historyService.getHistory(6);
		System.out.println(l);
		System.out.println(ModelToJson.getJSONArray(l));
		
	}
}
