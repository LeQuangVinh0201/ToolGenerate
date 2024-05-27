package com.baont8.toolgenerate.service.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YesNoTypeDto {

	@JsonProperty(value = "YN_TYPE")
	private String ynType;

	@JsonProperty(value = "YN_DESC")
	private String ynDesc;

	@JsonProperty(value = "YN_VALUE")
	private boolean ynValue;

	public String getYnType() {
		return ynType;
	}

	public void setYnType(String ynType) {
		this.ynType = ynType;
	}

	public String getYnDesc() {
		return ynDesc;
	}

	public void setYnDesc(String ynDesc) {
		this.ynDesc = ynDesc;
	}

	public boolean isYnValue() {
		return ynValue;
	}

	public void setYnValue(boolean ynValue) {
		this.ynValue = ynValue;
	}

}
