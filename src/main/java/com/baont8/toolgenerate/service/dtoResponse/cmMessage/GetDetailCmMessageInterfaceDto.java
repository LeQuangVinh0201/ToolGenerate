package com.baont8.toolgenerate.service.dtoResponse.cmMessage;

import org.springframework.beans.factory.annotation.Value;

public interface GetDetailCmMessageInterfaceDto {

	@Value("#{target.MSG_GRP}")
    String getMsgGrp();

	@Value("#{target.MSG_CD}")
    String getMsgCd();
    
	@Value("#{target.COMP_CD}")
    String getCompCd();

	@Value("#{target.MSG_TYPE}")
    String getMsgType();
    
	@Value("#{target.SYS_CD}")
    String getSysCd();
	
	@Value("#{target.CAT_TYPE}")
    String getCatType();
	
	@Value("#{target.MSG_KO}")
    String getMsgKo();
	
	@Value("#{target.MSG_EN}")
    String getMsgEn();

}
