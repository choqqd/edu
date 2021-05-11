package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/local")
public class LocalTestServlet extends HttpServlet{
	int number = 0;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String str = req.getParameter("msg");
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Thread Test</title></head>");
		out.print("<body><h2>처리결과(지역번수)</h2>");
		while(number++ <10) {
			out.print(str + " : " + number+"<br>");
			out.flush();
			System.out.println(str+ " : " + number);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		out.print("<h2>Done: " + str + "</h2>");
		out.print("</body></html>");
		out.close();
	}

}
