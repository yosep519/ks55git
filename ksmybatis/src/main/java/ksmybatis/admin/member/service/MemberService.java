package ksmybatis.admin.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import ksmybatis.admin.member.domain.Member;

@Service
public interface MemberService {
	
	// 회원정보일치 확인
	Map<String, Object> matchMember(String memberId, String memberPw);
	
	// 회원탈퇴
	void removeMember(String memberId);
	
	// 특정회원수정
	void modifyMemberInfo(Member member); 
	
	// 특정회원조회
	Member getMemberInfoById(String memberId);
	
	// 회원목록조회
	List<Member> getMemberList();
	
	// 회원등록
	void addMember(Member member);
}
