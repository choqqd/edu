package com.edu.test.stateless;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberRegister")
public class PutMemberServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//db에서 리스트 => memberList.jsp
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		MemberDAO dao = new MemberDAO();
		List<Member> list = dao.getMemberList();
		
		RequestDispatcher rd = req.getRequestDispatcher("memberList.jsp");
		req.setAttribute("memberList", list);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// parameter 를 읽고 db insert, memberResult.jsp
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String age = req.getParameter("age");

		Member member = new Member();
		member.setMemberId(Integer.parseInt(id));
		member.setMemberPwd(pwd);
		member.setMemberName(name);
		member.setMemberAge(Integer.parseInt(age));

		MemberDAO dao = new MemberDAO();
		dao.insertMember(member);
		System.out.println("db에 입력되었습니다.");
		// this.getServletContext(); //ServletContext - RD객체 호출하기위해
		RequestDispatcher rd = req.getRequestDispatcher("memberResult.jsp"); // 한건의 Dispatcher
		req.setAttribute("member", member);
		rd.forward(req, resp);
	}
}
