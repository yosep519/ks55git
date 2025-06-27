package ksmybatis.admin.vendor.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ksmybatis.admin.vendor.domain.Vendor;
import ksmybatis.admin.vendor.service.VendorService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin/vendor")
@RequiredArgsConstructor
public class VendorController {

	private final VendorService vendorService;
	
	// 거래처 목록 조회
	@GetMapping("/vendorList")
	public String VendorListView(Model model) {
		
		List<Vendor> vendorList = vendorService.getVendorList();
		
		model.addAttribute("title", "거래처목록조회");
		model.addAttribute("vendorList", vendorList);
		
		return "admin/vendor/vendorListView";
	}
}
