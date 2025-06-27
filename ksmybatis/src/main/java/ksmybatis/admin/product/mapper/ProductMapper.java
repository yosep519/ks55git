package ksmybatis.admin.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmybatis.admin.product.domain.Product;

@Mapper
public interface ProductMapper {
	
	// 판매자가 등록한 상품 삭제
	int removeProductBySellerId(String sellerId);
	
	// 상품목록조회
	List<Product> getProductList();
}
