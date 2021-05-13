package com.edu.test.stateless;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	MemberDAO() {
		DataSource ds = DataSource.getIncetance();
		conn = ds.getConnection();

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
