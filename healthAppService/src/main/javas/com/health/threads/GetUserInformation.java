package com.health.threads;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


public class GetUserInformation implements Runnable {
	private HttpServletResponse response;
	private String userInformation;
	public GetUserInformation(HttpServletResponse response, String userInformation) {
		this.response = response;
		this.userInformation = userInformation;
	}
	public void run() {
		try {
			response.getWriter().println(userInformation);
	        System.out.println (userInformation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
