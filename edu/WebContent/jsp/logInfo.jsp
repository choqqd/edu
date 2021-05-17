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
	if(request.getMethod().equals("POST")){
		if(mem==null||mem.getMemberId() == 0){
			out.print("<h3>사용자정보가 없습니다.</h3>");
		}else{
			session.setAttribute("info", mem);
			out.print("<h3>이름: "+mem.getMemberName()+"나이: "+mem.getMemberAge()+" </h3><br>");
		}
	 // get -> 로그아웃
	 }else{
		 session.invalidate();
		 out.print("로그아웃됨");
	 }
%>

</body>
</html>