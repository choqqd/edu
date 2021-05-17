<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Include 지시자 사용</h1>
<%=application.getAttribute("welcomeMsg").toString() %>
<%
	out.print("<h3>"+request.getAttribute("result").toString()+"</h3>");
%>
<jsp:include page="Copy.jsp"></jsp:include>
<%--<%@ include file="Copy.jsp" %>--%>
</body>
</html>