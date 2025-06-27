package ksmybatis.admin.vendor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ksmybatis.admin.vendor.domain.Vendor;

@Service
public interface VendorService {

	// 거래처 목록 조회
	List<Vendor> getVendorList();
}
