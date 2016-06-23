package com.health.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.health.model.PhysicalCondition;
import com.health.model.User;

@Component
public class GetBodyCondition {
	
	private User user;
	public void setUser (User user) {
		this.user = user;
	}
	public List<PhysicalCondition> getBodyCodition () {
		List<PhysicalCondition> list = new ArrayList<PhysicalCondition>();
		double low = 0, high = 0, body = 0;
		if (user.getSex().equals("女")) {
			PhysicalCondition p1 = new PhysicalCondition();
			low = ( user.getHeight() * 100 - 80 ) * 60 * 1.2;
			high = ( user.getHeight() * 100 - 80 ) * 60 * 0.8;
			String str1 = getCodition(low, high, user.getWeight());
			p1.setBodyType(1);
			p1.setTypeName(str1);
			list.add(p1);
			
			PhysicalCondition p2 = new PhysicalCondition();
			low = 28;
			high = 17.1;
			String str2 = null;
			if (user.getHeight() != 0)
				 str2 = getCodition(low, high, user.getUserDetails().getMassIndex() );
			p2.setBodyType(2);
			p2.setTypeName(str2);
			list.add(p2);
			
			PhysicalCondition p3 = new PhysicalCondition();
			low = 24;
			high = 17;
			String str3 = getCodition(low, high, user.getUserDetails().getFatRate());
			p3.setBodyType(3);
			p3.setTypeName(str3);
			list.add(p3);
			
			PhysicalCondition p4 = new PhysicalCondition();
			low = 54.46;
			high = 36.7;
			String str4 = getCodition(low, high, user.getUserDetails().getFatFreeMass());
			p4.setBodyType(4);
			p4.setTypeName(str4);
			list.add(p4);
			
			PhysicalCondition p5 = new PhysicalCondition();
			low = 2.5;
			high = 2.2;
			String str5 = getCodition(low, high, user.getUserDetails().getBoneMass());
			p5.setBodyType(5);
			p5.setTypeName(str5);
			list.add(p5);
			
			PhysicalCondition p6 = new PhysicalCondition();
			low = 31.2;
			high = 28.6;
			String str6 = getCodition(low, high, user.getUserDetails().getMoisture());
			p6.setBodyType(6);
			p6.setTypeName(str6);
			list.add(p6);
			
		}
		else {
			PhysicalCondition p1 = new PhysicalCondition();
			low = ( user.getHeight() * 100 - 80 ) * 70 * 1.2;
			high = ( user.getHeight() * 100 - 80 ) * 70 * 0.8;
			String str1 = getCodition(low, high, user.getWeight());
			p1.setBodyType(1);
			p1.setTypeName(str1);
			list.add(p1);
			
			PhysicalCondition p2 = new PhysicalCondition();
			low = 28;
			high = 17.8;
			String str2 = null;
			if (user.getHeight() != 0)
				 str2 = getCodition(low, high, user.getUserDetails().getMassIndex() );
			p2.setBodyType(2);
			p2.setTypeName(str2);
			list.add(p2);
			
			PhysicalCondition p3 = new PhysicalCondition();
			low = 20;
			high = 14;
			String str3 = getCodition(low, high, user.getUserDetails().getFatRate());
			p3.setBodyType(3);
			p3.setTypeName(str3);
			list.add(p3);
			
			PhysicalCondition p4 = new PhysicalCondition();
			low = 54.47;
			high = 36.83;
			String str4 = getCodition(low, high, user.getUserDetails().getFatFreeMass());
			p4.setBodyType(4);
			p4.setTypeName(str4);
			list.add(p4);
			
			PhysicalCondition p5 = new PhysicalCondition();
			low = 3.2;
			high = 2.9;
			String str5 = getCodition(low, high, user.getUserDetails().getBoneMass());
			p5.setBodyType(5);
			p5.setTypeName(str5);
			list.add(p5);
			
			PhysicalCondition p6 = new PhysicalCondition();
			low = 44.9;
			high = 39.5;
			String str6 = getCodition(low, high, user.getUserDetails().getMoisture());
			p6.setBodyType(6);
			p6.setTypeName(str6);
			list.add(p6);
			
		}
		return list;
	}
	public String getCodition (double low, double high, double body) {
		if (body > high)
			return "偏高";
		else if (body < low)
			return "偏低";
		else
			return "正常";
	}
}
