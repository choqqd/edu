<%@page import="com.edu.test.stateless.MemberDAO"%>
<%@page import="com.edu.test.stateless.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

	MemberDAO dao = new MemberDAO();
	Member mem = new Member();
	int id = Integer.parseInt(request.getParameter("id"));
	String pwd = request.getParameter("pwd");
	
	mem = dao.checkInfo(id, pwd);
	int age = mem.getMemberAge();
	String name = mem.getMemberName();
	if(name==null){
		out.print("사용자정보가 없습니다.");
	}else{
		%><h3>name: <%=name %></h3><br>
		<h3>Age: <%=age %></h3><%
	}
%>

</body>
</html>