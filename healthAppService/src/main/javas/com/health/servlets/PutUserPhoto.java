package com.health.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.health.model.User;
import com.health.service.impl.UserService;

/**
 * Servlet implementation class PutUserPhoto
 */
@Component
public class PutUserPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource
    private UserService userService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PutUserPhoto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		User user = userService.getUser(id);
		String url = user.getHeadPortrait();
		System.out.println(url);
		JSONObject json = new JSONObject();
		json.accumulate("url", url);
		response.getWriter().println(json.toString());
	}

}
