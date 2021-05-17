<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginOut.jsp</title>
</head>
<body>
<%
	String msg = (String)request.getAttribute("err");
	if(msg==null) {msg = "";}
%>
<%=msg %>
<%
	if(session.getAttribute("info") == null){
	%>
		<form action="logInfo.jsp" method = "POST">
			ID:<input type = "number" name = "id"><br>
			비밀번호:<input type = "password" name="pwd"><br>
			<input type="submit" value="로그인">
	
		</form>
	<%
	}else {
		%>
			<a href="logInfo.jsp">로그아웃</a>
		<%
				
	}
%>


</body>
</html>