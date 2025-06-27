package ksmybatis.admin.product.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmybatis.admin.product.domain.Product;
import ksmybatis.admin.product.service.ProductService;
import ksmybatis.admin.vendor.mapper.VendorMapper;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin/product")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;
	private final VendorMapper vendorMapper;
	/**
	 * 상품목록 조회
	 * @return productListView
	 */
	@GetMapping("/productList")
	public String productListView(Model model) {
		
		List<Product> productList = productService.getProductList();
		
		model.addAttribute("title", "상품목록조회");
		model.addAttribute("productList", productList);
		
		return "admin/product/productListView";
	}
	
	// 상품등록
	@GetMapping("/addProduct")
	public String addProduct() {
		return "admin/product/addProductView";
	}
	
	// 판매자확인
	@PostMapping("/idCheck")
	@ResponseBody
	public Boolean idCheck(@RequestParam String vendMbrId) {
		boolean isVendor = vendorMapper.checkVendorById(vendMbrId);
		return isVendor;
	}
}
