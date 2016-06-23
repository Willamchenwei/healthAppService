package com.health.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.health.model.PhysicalCondition;
import com.health.model.User;
import com.health.service.impl.UserService;
import com.health.util.Calculate;
import com.health.util.GetBodyCondition;
import com.health.util.JsonToModel;
import com.health.util.ReadStream;

/**
 * Servlet implementation class Register
 */
@Component("Register")
public class Register extends HttpServlet {
	@Resource
	private UserService userService;

	private static final long serialVersionUID = 1L;

	public Register() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		JSONObject json = new JSONObject();
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		if (userService.getUser(userName) != null) {
			json.accumulate("code", 0);
			response.getWriter().println(json.toString());
		} else {
			User user = new User();
			user.setUserName(userName);
			user.setUserPassword(userPassword);
			userService.addorUpdataUser(user);
			json.accumulate("code", 1);
			response.getWriter().println(json.toString());
		}
	}

}
