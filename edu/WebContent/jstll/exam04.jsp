<%@page import="com.edu.beans.BookBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<BookBean> booklist = new ArrayList<>();
	booklist.add(new BookBean("title1","author1","pub1"));
	booklist.add(new BookBean("title2","author2","pub2"));
	booklist.add(new BookBean("title3","author3","pub3"));
	request.setAttribute("list", booklist);
	

%>
<h3>forEach 반복문</h3>
<c:forEach items ="${list }" var ="book">
	<p>${book.title } / ${book.author } / ${book.publisher }</p>
</c:forEach>
<c:forEach begin = "2" end = "9" var = "val">
	<c:forEach begin = "1" end = "9" var = "num">
		<p>${val } * ${num } = ${val * num }</p>
	</c:forEach>
</c:forEach>
</body>
</html>