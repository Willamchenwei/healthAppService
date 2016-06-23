package com.health.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.health.model.History;
import com.health.model.User;
import com.health.service.impl.HistoryService;
import com.health.service.impl.UserService;
import com.health.util.Calculate;

/**
 * Servlet implementation class GetDetails
 */
@Component ("GetDetails")
public class GetDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource
	private UserService userService ;
	@Resource
	private Calculate calculate;
	@Resource
	private HistoryService historyService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "application/json;charset=UTF-8");

		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");

		String strId = request.getParameter("id");
		int id = 0;
		if (strId != null)
			id = Integer.parseInt(strId);
		String nickName = request.getParameter("nickName");
		String sex = request.getParameter("sex");
		double height = 0.0;
		double weight = 0.0;
		String h = request.getParameter("height");
		String w = request.getParameter("weight");
		if (h != null && w != null) {
			weight = Double.parseDouble(w);
			height = Double.parseDouble(h);
		}		
		String userDate = request.getParameter("userDate");
		String userDetailsDate = request.getParameter("userDetailsDate");
		Date date = null;
		Date detailsDate = null;
		if (userDate != null)
			try {
				date = formatter.parse(userDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (userDetailsDate != null) {
			try {
				detailsDate = formatter.parse(userDetailsDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		User user = userService.getUser(id);
		int detailsId = 0;
		if (user.getUserDetails() != null)
			detailsId = user.getUserDetails().getId();
		if (user != null) {
			double oldWeight = user.getWeight();
			double oldHeight = user.getHeight();
			user.setUserDate(date);
			user.setNickName(nickName);
			user.setSex(sex);
			user.setHeight(height);
			user.setWeight(weight);
			if (Math.abs(oldHeight - height) > 0.1 || Math.abs(oldWeight - weight ) > 0.1) {
				calculate.setUser(user);
				User u = calculate.calculateUserDetail();
				u.getUserDetails().setId(detailsId);
				u.getUserDetails().setDetailsDate(detailsDate);
				userService.addorUpdataUser(u);
				System.out.println(u);
				JSONObject json = new JSONObject();
				json.accumulate("fat", u.getUserDetails().getFat());
				json.accumulate("boneMass", u.getUserDetails().getBoneMass());
				json.accumulate("fatFreeMass", u.getUserDetails().getFatFreeMass());
				json.accumulate("fatRate", u.getUserDetails().getFatRate());
				json.accumulate("massIndex", u.getUserDetails().getMassIndex());
				json.accumulate("moisture", u.getUserDetails().getMoisture());
				response.getWriter().println(json.toString());
				History history = new History();
				history.setUserId(u.getId());
				history.setFat(u.getUserDetails().getFat());
				history.setFatFreeMass(u.getUserDetails().getFatFreeMass());
				history.setFatRate(u.getUserDetails().getFatRate());
				history.setWeight(u.getWeight());
				history.setMoisture(u.getUserDetails().getMoisture());
				history.setHistoryDate(u.getUserDetails().getDetailsDate());
				historyService.addorUpdataHistory(history);
			}
			userService.addorUpdataUser(user);

		}
	}

}
