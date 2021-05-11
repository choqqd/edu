package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitparamServlet extends HttpServlet {
	String id, password;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		id = config.getInitParameter("id"); //web.xml에 지정해놓은 파라미터 값을 가져옴
		password = config.getInitParameter("password"); 
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<h3>" + id + "</h3>");
		out.print("<h3>" + password + "</h3>");
	}
}
