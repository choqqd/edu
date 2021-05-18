package com.edu.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	//전체 리스트 조회 , 신규 입력, 수정, 삭제 - DBMS
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	/* ------------------------------------------------------------------
	 * --------------------------- 한 건 조 회 ---------------------------
	 * ------------------------------------------------------------------
	 * */
	
	public BookBean getBook(String title) {
		String sql = "select * from book where title = ?";
		conn = DAO.connet();
		BookBean book = new BookBean();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			rs = psmt.executeQuery();
			if(rs.next()) {
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setTitle(rs.getString("title"));
				System.out.println("정상조회");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return book;
	}
	
	
	/* ------------------------------------------------------------------
	 * --------------------------- 전 체 조 회 ---------------------------
	 * ------------------------------------------------------------------*/
	public List<BookBean> getBookList(){
		String sql = "select * from book";
		List<BookBean> Booklist = new ArrayList<>();
		BookBean book = new BookBean();
		conn = DAO.connet();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setTitle(rs.getString("title"));
				
				Booklist.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return Booklist;
	}
	
	/* ------------------------------------------------------------------
	 * --------------------------- 저자별 조 회 ---------------------------
	 * ------------------------------------------------------------------*/
	public List<BookBean> getBooksByAuthor(String Author) {
		String Sql = "select * from book where Author = ?";
		List<BookBean> Booklist = new ArrayList<>();
		BookBean book = new BookBean();
		conn = DAO.connet();
		try {
			psmt = conn.prepareStatement(Sql);
			psmt.setString(1, Author);
			rs = psmt.executeQuery();
			while(rs.next()) {
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setTitle(rs.getString("title"));
				
				Booklist.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return Booklist;
	}
	
	/* ------------------------------------------------------------------
	 * --------------------------- 한 건 입 력 ----------------------------
	 * ------------------------------------------------------------------*/
	public BookBean InsertBook(BookBean book) {
		String sql = "insert into book values(?,?,?)";
		conn = DAO.connet();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getTitle());
			psmt.setString(2, book.getAuthor());
			psmt.setString(3, book.getPublisher());
			
			int r = psmt.executeUpdate();
			System.out.println(r+" 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return book;
	}
	
	
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
