package com.baont8.toolgenerate.service.dtoRequest.setting;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SettingFileCreMessageNextHrRequestDto {

	@JsonProperty(value = "FILE_TEMPLATE_ID")
	private int fileTemplateId;

	public int getFileTemplateId() {
		return fileTemplateId;
	}

	public void setFileTemplateId(int fileTemplateId) {
		this.fileTemplateId = fileTemplateId;
	}

}
