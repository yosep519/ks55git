package ksmybatis.admin.member.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmybatis.admin.member.domain.Member;
import ksmybatis.admin.member.mapper.MemberMapper;
import ksmybatis.admin.member.service.MemberService;
import ksmybatis.admin.order.mapper.OrderMapper;
import ksmybatis.admin.product.mapper.ProductMapper;
import ksmybatis.admin.vendor.mapper.VendorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService{

	private final MemberMapper memberMapper;
	private final VendorMapper vendorMapper;
	private final ProductMapper productMapper;
	private final OrderMapper orderMapper;
	
	// 회원정보일치 확인
	@Override
	public Map<String, Object> matchMember(String memberId, String memberPw) {
		boolean isMatch = false;
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		Member memberInfo = memberMapper.getMemberInfoById(memberId);
		if(memberInfo != null) {
			String checkPw = memberInfo.getMemberPw();
			if(memberPw.equals(checkPw)) {
				isMatch = true;
				resultMap.put("memberInfo", memberInfo);
			}
		}
		resultMap.put("isMatch", isMatch);
		return resultMap;
	};
	
	// 회원탈퇴
	@Override
	public void removeMember(String memberId) {
		Member memberInfo = memberMapper.getMemberInfoById(memberId);
		String memberLevel = memberInfo.getMemberLevel();
		
		switch (memberLevel) {
			case "mbr_grd_2" -> {
				// 1. 주문상세
				orderMapper.removeOrderItemBySellerId(memberId);
				log.info("주문상세");
				// 2. 상품
				productMapper.removeProductBySellerId(memberId);
				log.info("상품");
				// 3. 거래처
				vendorMapper.removeVendorBySellerId(memberId);
				log.info("거래처");
			}
			case "mbr_grd_3" -> {
				var orderNum = orderMapper.getOrderNumById(memberId);
				if(orderNum != null && orderNum.size() > 0) {
					// 1. 주문상세
					orderMapper.removeOrderItemByNum(orderNum);
					// 2. 주문
					orderMapper.removeOrderById(memberId);
				}
			}
		}
		// 로그인이력
		memberMapper.removeMemberLoginLogById(memberId);
		// 회원탈퇴
		memberMapper.removeMemberById(memberId);

	}
	
	// 특정회원수정
	@Override
	public void modifyMemberInfo(Member member) {
		memberMapper.modifyMemberInfo(member);
	}
	
	// 특정회원조회
	@Override
	public Member getMemberInfoById(String memberId) {
		Member memberInfo = memberMapper.getMemberInfoById(memberId);
		String memberTelNo = memberInfo.getMemberTelNo();
		String[] memberTelNoArr = memberTelNo.split("-");
		
		String memberTelNo1 = memberTelNoArr[0];
		String memberTelNo2 = memberTelNoArr[1];
		String memberTelNo3 = memberTelNoArr[2];
		
		memberInfo.setMemberTelNo1(memberTelNo1);
		memberInfo.setMemberTelNo2(memberTelNo2);
		memberInfo.setMemberTelNo3(memberTelNo3);
		
		return memberInfo;
	}
	
	// 회원목록조회
	@Override
	public List<Member> getMemberList() {
		List<Member> memberList = memberMapper.getMemberList(); 
		return memberList;
	}
	
	// 회원등록
	@Override
	public void addMember(Member member) {
		int result = memberMapper.addMember(member);
		String insertResult = "회원등록 실패";
		if(result > 0) insertResult = "회원등록 성공";
		
		log.info(insertResult);
	}
}
