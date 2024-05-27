package com.baont8.toolgenerate.service.dto.fileTemplateParameter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParameterTypeDto {

	@JsonProperty(value = "PARAMETER_TYPE")
	private String parameterType;

	@JsonProperty(value = "PARAMETER_DESC")
	private String parameterDesc;

	public String getParameterType() {
		return parameterType;
	}

	public void setParameterType(String parameterType) {
		this.parameterType = parameterType;
	}

	public String getParameterDesc() {
		return parameterDesc;
	}

	public void setParameterDesc(String parameterDesc) {
		this.parameterDesc = parameterDesc;
	}

}
