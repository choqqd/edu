package com.edu.test.stateless;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context1")
public class ServletContextTest1Servlet extends HttpServlet{
	ServletContext sc;
	
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		sc = config.getServletContext();
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		sc = this.getServletContext();
		String location = sc.getInitParameter("data1");
		System.out.println(location);
	}
}
