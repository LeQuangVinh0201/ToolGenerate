package com.baont8.toolgenerate.service.dtoRequest.generateDatasetAndColumnModel;

import com.baont8.toolgenerate.enumration.PositionEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GenerateDatasetAndColumnModelRequestDto {

	@JsonProperty(value = "BIZACTOR_INPUT")
	private String bizactorInput;

	@JsonProperty(value = "COMPA_POSITION")
	private PositionEnum compaPostion = PositionEnum.RIGHT;

	public String getBizactorInput() {
		return bizactorInput;
	}

	public void setBizactorInput(String bizactorInput) {
		this.bizactorInput = bizactorInput;
	}

	public PositionEnum getCompaPostion() {
		return compaPostion;
	}

	public void setCompaPostion(PositionEnum compaPostion) {
		this.compaPostion = compaPostion;
	}

}
