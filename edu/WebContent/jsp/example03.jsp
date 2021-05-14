<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>
<!-- example03.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외상황</title>
</head>
<body>
<h4>다음 에러가 발생했습니다.</h4>
에러타입: <%=exception.getClass().getName() %><br>
에러내용: <%=exception.getMessage() %>
</body>
</html>