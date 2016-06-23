package com.health.servlets;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.health.model.User;
import com.health.model.UserDynamic;
import com.health.service.impl.UserService;
import com.health.util.ModelToJson;

/**
 * Servlet implementation class PutUserDynamic
 */
@Component ("PutUserDynamic")
public class PutUserDynamic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource
	private UserService userService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PutUserDynamic() {
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
		response.setHeader("Content-Type", "application/json;charset=UTF-8");
		String str = request.getParameter("id");
		System.out.println(str);
		int userId = 0;
		User user = new User ();
		if (str != null) {
			userId = Integer.parseInt(str);
		}
		if (userId != 0) 
			user = userService.getUser(userId);
		List<UserDynamic> dyList = user.getUserDynamic();
		String res;
		if (dyList.size() != 0) {
			res = ModelToJson.getDynamicJson(dyList);
			System.out.println(res);
			response.getWriter().println(res);
		}
	}

}
