package ksmybatis.admin.product.domain;

import lombok.Data;

@Data
public class Product {

	private String prodCd; 
	private String vendCd; 
	private String prodName; 
	private int prodUntPrc; 
	private String prodRegDate;
}
