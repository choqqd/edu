package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/netInfo")
public class NetInfoServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head><title>Request정보 출력</title></head>");
		out.print("<body>");
		out.print("<h3>네트워크 관련 요청</h3>");
		out.print("Request Scheme: " + req.getScheme() + "<hr>");
		out.print("Server Name: " + req.getServerName() + "<hr>");
		out.print("Server Address: " + req.getLocalAddr() + "<hr>");
		out.print("Server Port: " + req.getServerPort() + "<hr>");
		out.print("Client Address: " + req.getRemoteAddr() + "<hr>");
		out.print("Client Host: " + req.getRemoteHost() + "<hr>");
		out.print("Client Port: "+ req.getRemotePort() + "<hr>");

		out.print("<h3>URL 정보</h3>");
		out.print("Request URI: " + req.getRequestURI() + "<hr>");
		out.print("Request URL: " + req.getRequestURL() + "<hr>");
		out.print("Context path: " + req.getContextPath() + "<hr>");
		out.print("Request Protocol: " + req.getProtocol() + "<hr>");
		out.print("Server path: " + req.getServletPath() + "<hr>");
		out.print("</body></html>");
		out.close();
		

		
	}

}
