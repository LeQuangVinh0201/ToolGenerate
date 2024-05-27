package com.baont8.toolgenerate.service.dtoRequest.screen;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetScreenDetailRequestDto {

	@JsonProperty(value = "SCREEN_ID")
	private int screenId;

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

}
