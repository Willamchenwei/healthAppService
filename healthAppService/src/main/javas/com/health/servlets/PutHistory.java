package com.health.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.springframework.stereotype.Component;

import com.health.model.History;
import com.health.service.impl.HistoryService;
import com.health.util.ModelToJson;

/**
 * Servlet implementation class PutHistory
 */
@Component("PutHistory")
public class PutHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource
	private HistoryService historyService;

	public PutHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "application/json;charset=UTF-8");
		String str = request.getParameter("id");
		int id = 0;
		if (str != null)
			id = Integer.parseInt(str);
		List<History> history = historyService.getHistory(id);
		if (history.size() != 0) {
			String historyStr = ModelToJson.getJSONArray(history);
			System.out.println(historyStr);
			response.getWriter().println(historyStr);
		}
	}

}
