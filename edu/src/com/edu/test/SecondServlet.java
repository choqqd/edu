package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/secondServlet", "/second" })
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SecondServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("name:"+name);
		System.out.println("age:"+age);
		
//		Enumeration<String> en = request.getHeaderNames();
//		while(en.hasMoreElements()) {
//			String key = en.nextElement();
//			String val = request.getHeader(key);
//			System.out.println(key+ "," +val);
//		}
//		

//		ArrayList<String> col = (ArrayList<String>)response.getHeaderNames();
//		for(String key : col) {
//			String val = response.getHeader(key);
//			System.out.println(key + ","+val);
//		}
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		response.sendRedirect("index.html");
		PrintWriter out = response.getWriter();
		out.print("<h1>" + name + "</h1>");
		out.print("<h1>" + age + "</h1>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
