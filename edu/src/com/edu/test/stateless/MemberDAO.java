package com.edu.test.stateless;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	   public MemberDAO() {
//	      DataSource ds = DataSource.getInstance(); // DB 연결
//	      conn = ds.getConnection();
	      //Connection Poll 을 활용해서 Connection 객체 사용
	      try {
	         InitialContext ic = new InitialContext(); // 서버의 리소스를 관리하는 객체
	         javax.sql.DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
	         conn = ds.getConnection();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
//한건조회
	public Member getMember(int id) {
		String sql = "select * from member where MEMBER_ID=?";
		Member mem = new Member();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				mem.setMemberId(rs.getInt("member_id"));
				mem.setMemberPwd(rs.getString("member_pwd"));
				mem.setMemberAge(rs.getInt("member_age"));
				mem.setMemberName(rs.getString("member_name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return mem;
	}
	
	public Member checkInfo(int id, String pwd) {
		String sql = "select * from member where MEMBER_ID=? and MEMBER_PWD = ?";
		Member mem = new Member();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.setString(2, pwd);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				mem.setMemberId(rs.getInt("member_id"));
				mem.setMemberPwd(rs.getString("member_pwd"));
				mem.setMemberAge(rs.getInt("member_age"));
				mem.setMemberName(rs.getString("member_name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return mem;
	}
	
	public List<Member> getMemberList() {
		String sql = "select * from member order by 1";
		List<Member> list = new ArrayList<Member>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Member mem = new Member();
				mem.setMemberAge(rs.getInt("member_age"));
				mem.setMemberId(rs.getInt("member_id"));
				mem.setMemberName(rs.getString("member_name"));
				mem.setMemberPwd(rs.getString("member_pwd"));

				list.add(mem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	public void insertMember(Member mem) {
		String sql = "insert into member VALUES(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, mem.getMemberId());
			psmt.setString(2, mem.getMemberName());
			psmt.setInt(3, mem.getMemberAge());
			psmt.setString(4, mem.getMemberPwd());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
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
