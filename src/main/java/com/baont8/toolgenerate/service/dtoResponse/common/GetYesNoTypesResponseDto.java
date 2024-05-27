package com.baont8.toolgenerate.service.dtoResponse.common;

import java.util.ArrayList;
import java.util.List;

import com.baont8.toolgenerate.service.dto.common.YesNoTypeDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetYesNoTypesResponseDto {

	@JsonProperty(value = "YN_TYPES")
	private List<YesNoTypeDto> ynTypes = new ArrayList<>();

	public List<YesNoTypeDto> getYnTypes() {
		return ynTypes;
	}

	public void setYnTypes(List<YesNoTypeDto> ynTypes) {
		this.ynTypes = ynTypes;
	}

}
