<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example01.jsp</title>
</head>
<body>
<%!  //jsp에서 !는 필드(멤버변수), 메소드 정의가능
	String name;
	public int sum(int a, int b){
		return a+b;
	}
%>
<%
	
	String user = request.getParameter("name");
	if(user == null){
		user = "Guest";
	}
	int result = sum(10,20);
%>
<h1>ㅎㅇ <%=user %> 어서오고</h1>
<h2>결과값: <%=result %></h2>

</body>
</html>