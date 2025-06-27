package ksmybatis.admin.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
	
	// 구매자 주문이력 삭제
	int removeOrderById(String customerId);
	
	// 구매번호로 구매상세이력 삭제
	int removeOrderItemByNum(List<Integer> list);
	
	// 구매자 구매번호 조회
	List<Integer> getOrderNumById(String customerId);
	
	// 판매자가 등록한 상품을 구매한 이력 삭제
	int removeOrderItemBySellerId(String sellerId);
}
