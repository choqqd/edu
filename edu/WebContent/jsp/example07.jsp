<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Example07.jsp::: 스크립트릿(애플릿,서블릿)</title>

</head>
<body>
<%!

%>
	<h3>테이블 활용하기</h3>

	<table border="1">
		<%
		for (int i = 1; i < 10; i++) {
		%><tr>
			<%
			for (int j = 2; j < 10; j++) {
				out.print("<td>" + j + "</td><td> * </td><td>" + i + "</td><td> = </td><td>" + (i * j) + "</td>");
			}
			%></tr><%
		}
			%>
		
	</table>

</body>
</html>