<%@page import="com.edu.test.stateless.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Example17.jsp</title>
</head>
<body>
<%
	String id = request.getParameter("memberId");
	String pw = request.getParameter("memberPwd");
	String nm = request.getParameter("memberName");
	String ag = request.getParameter("memberAge");

	Member member1 = new Member();
	
	member1.setMemberId(Integer.parseInt(id));
	member1.setMemberName(nm);
	member1.setMemberAge(Integer.parseInt(ag));
	member1.setMemberPwd(pw);
	
	out.print(member1.getMemberId() +"<br>");
	out.print(member1.getMemberName() +"<br>");
	out.print(member1.getMemberAge() +"<br>");
	out.print(member1.getMemberPwd() +"<br>");
%>
<jsp:useBean id="member2" class="com.edu.test.stateless.Member"></jsp:useBean>
<jsp:setProperty property="*" name="member2"/>

<jsp:getProperty property="memberId" name="member2"/><br>
<jsp:getProperty property="memberPwd" name="member2"/><br>
<jsp:getProperty property="memberName" name="member2"/><br>
<jsp:getProperty property="memberAge" name="member2"/>
</body>
</html>