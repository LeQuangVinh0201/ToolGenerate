package com.baont8.toolgenerate.service.dtoResponse.fileTemplateParameter;

import java.util.ArrayList;
import java.util.List;

import com.baont8.toolgenerate.service.dto.fileTemplateParameter.ParameterTypeDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetParameterTypesResponseDto {

	@JsonProperty(value = "PARAMETER_TYPES")
	private List<ParameterTypeDto> parameterTypes = new ArrayList<>();

	public List<ParameterTypeDto> getParameterTypes() {
		return parameterTypes;
	}

	public void setParameterTypes(List<ParameterTypeDto> parameterTypes) {
		this.parameterTypes = parameterTypes;
	}

}
