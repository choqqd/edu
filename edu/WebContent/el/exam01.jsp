<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Language</title>
</head>
<body>
<%
	//String name = "Hello";
	//request.setAttribute("name", name);
	
	String name = request.getParameter("name");
	String age = request.getParameter("age");
%>
<%=name %>/<%=age %>
<h3>${param.name } / ${param["age"] }</h3>
</body>
</html>