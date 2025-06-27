package ksmybatis.admin.common.domain;

import lombok.Data;

@Data
public class CommonCode {
	// CommonGroupCode
	private String commGroupCd;
	private String commGroupNm;
	private String commGroupEngNm;
	// CommonCode
	private String commCd;
	private String commNm;
	private String commEngNm;
	private String commCdUseYn;
	private String commCdRegDate;
}
