<%@page import="com.edu.member.model.MemberVO"%>
<%@page import="com.edu.member.model.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//사용자 입력 -> oracle 저장 -> 처리결과(memberOut.jsp)
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String mail = request.getParameter("mail");
	
	MemberVO member = new MemberVO();
	member.setId(id);
	member.setPassword(password);
	member.setName(name);
	member.setMail(mail);
	//서비스 로직(MemberService.java)

	//DB처리(MemberDAO.java)
	MemberService service = new MemberService();
	service.memberInsert(member);
	
	request.setAttribute("member", member);
	
	//처리결과memberOutput.jsp)
	RequestDispatcher rd = request.getRequestDispatcher("memberOutput.jsp");
	rd.forward(request, response);
%>