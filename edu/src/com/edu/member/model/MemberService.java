package com.edu.member.model;

public class MemberService {
	//처리로직
	//입력, 조회, 수정, 삭제 기능구현
	MemberDAO dao = new MemberDAO();
	public void memberInsert(MemberVO member) {
		dao.insertMember(member);
	}
}
