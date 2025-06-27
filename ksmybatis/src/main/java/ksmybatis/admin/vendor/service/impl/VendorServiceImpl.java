package ksmybatis.admin.vendor.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ksmybatis.admin.vendor.domain.Vendor;
import ksmybatis.admin.vendor.mapper.VendorMapper;
import ksmybatis.admin.vendor.service.VendorService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VendorServiceImpl implements VendorService {
	
	private final VendorMapper vendorMapper;
	
	// 거래처 목록 조회
	@Override
	public List<Vendor> getVendorList() {
		List<Vendor> VendorList = vendorMapper.getVendorList();
		return VendorList;
	}
}
