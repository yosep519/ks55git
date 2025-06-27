package ksmybatis.admin.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmybatis.admin.product.domain.Product;
import ksmybatis.admin.product.mapper.ProductMapper;
import ksmybatis.admin.product.service.ProductService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	
	private final ProductMapper productMapper;
	
	/**
	 * 상품목록조회
	 */
	@Override
	public List<Product> getProductList() {
		List<Product> productList = productMapper.getProductList();
		return productList;
	}
	
}
