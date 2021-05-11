package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/queryTest")
public class QueryTestServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String[] hobby = req.getParameterValues("hobby"); //문자열 배열
		String gender = req.getParameter("gender");
		String religion = req.getParameter("religion");
		String introduction = req.getParameter("introduction");
		
		out.print("<html><head><title>Query 문자열</title></head>");
		out.print("<body><h1>Get방식요청</h1>");
		out.print("<h3>아이디:"+id+"</h3>");
		out.print("<h3>비밀번호:"+pwd+"</h3>");
		out.print("<h3>이름:"+name+"</h3>");
		for(String hob : hobby) {			
			out.print("<h3>취미:"+hob+"</h3>");
		}
		out.print("<h3>성별:"+gender+"</h3>");
		out.print("<h3>종교:"+religion+"</h3>");
		out.print("<h3>자기소개:"+introduction+"</h3>");
		out.print("<h3>QueryString: "+req.getQueryString() + "</h3>");
		out.print("</body></html>");
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();

		out.print("<html><head><title>Query 문자열</title></head>");
		out.print("<body><h1>post방식요청</h1>");
		
		ServletInputStream input = req.getInputStream();
		int len = req.getContentLength();
		byte[] buf = new byte[len];
		input.readLine(buf, 0, len);
		String str = new String(buf);
		
		out.print("<h3>str: "+ len + str+ "</h3>");
		out.print("</body></html>");
		out.close();
	}
}
