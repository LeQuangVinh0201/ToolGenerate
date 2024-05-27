package com.baont8.toolgenerate.service.projectCustomer;

import java.util.List;
import java.util.Set;

import com.baont8.toolgenerate.service.dtoRequest.fileTemplate.GenerateFileTemplateRequestDto;
import com.baont8.toolgenerate.service.dtoResponse.cmMessage.GetCmMessageDetailResponseDto;

public interface ProjectCustomerService {

	public List<GetCmMessageDetailResponseDto> getListCmMessage(String msg, Set<String> listLangCd
			, Set<String> listMsgGrp, Set<String> listMsgType, Set<String> listSysCd, Set<String> listCompCd, String messageCd);

	public boolean checkExistsCmMessage(String msg, Set<String> listLangCd
			, Set<String> listMsgGrp, Set<String> listMsgType, Set<String> listSysCd, Set<String> listCompCd, String messageCd);

	public boolean saveCmMessageIntoNextHRCore(GenerateFileTemplateRequestDto requestDto) throws Exception;

}
