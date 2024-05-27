package com.baont8.toolgenerate.service.dtoRequest.fileTemplate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetFileTemplateRequestDto {

	@JsonProperty(value = "FILE_TEMPLATE_ID")
	private int fileTemplateId;

	public int getFileTemplateId() {
		return fileTemplateId;
	}

	public void setFileTemplateId(int fileTemplateId) {
		this.fileTemplateId = fileTemplateId;
	}

}
