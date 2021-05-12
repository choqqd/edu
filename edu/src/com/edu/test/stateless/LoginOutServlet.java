package com.edu.test.stateless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logProc")
public class LoginOutServlet extends HttpServlet{
	//로그인 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		if(id.isEmpty() || pwd.isEmpty()) {
			out.print("ID 또는 비번을 입력하세요");
			return;
		}
		HttpSession session = req.getSession();
		if(session.isNew() || session.getAttribute("id") == null) {
			session.setAttribute("id", id);
			session.setAttribute("data1", "100");
			out.print("로그인 완료");
		}else {
			out.print("이미 로그인 상태입니다.");
		}
		out.close();
	}
	
	
	//로그아웃 처리
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(false);
		if(session != null && session.getAttribute("id")!=null) {
			session.invalidate();
			out.print("로그아웃");
		}else {
			out.print("로그인상태가 아닙니다.");
		}
		out.close();
	}
}
