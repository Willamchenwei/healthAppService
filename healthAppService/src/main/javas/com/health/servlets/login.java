package com.health.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.health.model.User;
import com.health.service.impl.UserService;
import com.health.threads.GetUserInformation;
import com.health.util.ModelToJson;

@Component
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource
	private UserService userService;

    public login() {
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
		String userName = request.getParameter("userName");
		System.out.println(userName);
		String userPassword = request.getParameter("userPassword");
		User user = new User();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		User result = userService.checkUser(user);
		if (result != null) {
			String jsonString = ModelToJson.userToJson(result);
			String str = new String (jsonString.getBytes(), "UTF-8" );
			System.out.println (str);
			response.getWriter().println(str);
			//new Thread(new GetUserInformation(response, jsonString)).start();
		}
		else {
			JSONObject jsonObject = new JSONObject();
			jsonObject.accumulate("code", 0);
			response.getWriter().println(jsonObject.toString());
		}
	}

}
