package com.baont8.toolgenerate.service.dtoRequest.projectCustomer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CocCocTranslateRequestDto {

	@JsonProperty(value = "Text")
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public CocCocTranslateRequestDto(String text) {
		super();
		this.text = text;
	}

	public CocCocTranslateRequestDto() {
		super();
	}

}
