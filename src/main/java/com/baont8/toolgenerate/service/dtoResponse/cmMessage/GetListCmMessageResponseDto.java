package com.baont8.toolgenerate.service.dtoResponse.cmMessage;

import java.util.ArrayList;
import java.util.List;

public class GetListCmMessageResponseDto {

	private List<GetCmMessageDetailResponseDto> cmMessages = new ArrayList<>();

	public List<GetCmMessageDetailResponseDto> getCmMessages() {
		return cmMessages;
	}

	public void setCmMessages(List<GetCmMessageDetailResponseDto> cmMessages) {
		this.cmMessages = cmMessages;
	}

}
