<%@page import="com.edu.beans.BookDAO"%>
<%@page import="com.edu.beans.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	BookDAO dao = new BookDAO();
	BookBean book = new BookBean();

	if(request.getMethod().equals("POST")){
		//입력
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		
		//디비에 입력
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setTitle(title);
		dao.InsertBook(book);
	}else{
		//조회
		String title = request.getParameter("title");
		book = dao.getBook(title);
	}
	
	
	request.setAttribute("book", book);
	
	RequestDispatcher rd = request.getRequestDispatcher("bookOutput.jsp");
	rd.forward(request, response);
	
%>