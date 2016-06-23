package com.health.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.health.model.User;
import com.health.model.UserDetails;
import com.health.service.impl.UserService;
import com.health.util.ModelToJson;

/**
 * Servlet implementation class PutUserDetails
 */
@Component ("PutUserDetails")
public class PutUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Resource
    private UserService userService;
    
    public PutUserDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		User user = userService.getUser(id);
		UserDetails userDetails = user.getUserDetails();
		String str = ModelToJson.objToJson(userDetails);
		response.getWriter().println(str);
	}

}
