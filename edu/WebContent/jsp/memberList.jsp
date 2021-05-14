<%@page import="com.edu.test.stateless.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList</title>
</head>
<body>
	<table border="1">
	<tr><th>회원 아이디</th><th>회원이름</th><th>회원 나이</th></tr>
		<%
		List<Member> list = (List<Member>) request.getAttribute("memberList");
		for (Member mem : list) {
			out.print("<tr><td>"+mem.getMemberId() + "</td><td>" + mem.getMemberName() + "</td>");
			out.print("<td>"+mem.getMemberAge() + "</td></tr>");
		}
		%>
	</ul>
</body>
</html>