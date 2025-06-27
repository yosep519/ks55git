package ksmybatis.admin.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ksmybatis.admin.product.domain.Product;

@Service
public interface ProductService {
	
	// 상품목록조회
	List<Product> getProductList();
}
