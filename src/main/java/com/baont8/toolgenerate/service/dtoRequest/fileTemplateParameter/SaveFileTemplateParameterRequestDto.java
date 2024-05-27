package com.baont8.toolgenerate.service.dtoRequest.fileTemplateParameter;

import java.util.ArrayList;
import java.util.List;

import com.baont8.toolgenerate.service.dto.fileTemplateParameter.FileTemplateParameterDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaveFileTemplateParameterRequestDto {

	@JsonProperty(value = "FILE_TEMPLATE_ID")
	private Integer fileTemplateId;

	@JsonProperty(value = "FILE_TEMPLATE_PARAMETERS")
	List<FileTemplateParameterDto> fileTemplateParams = new ArrayList<>();

	public List<FileTemplateParameterDto> getFileTemplateParams() {
		return fileTemplateParams;
	}

	public void setFileTemplateParams(List<FileTemplateParameterDto> fileTemplateParams) {
		this.fileTemplateParams = fileTemplateParams;
	}

	public Integer getFileTemplateId() {
		return fileTemplateId;
	}

	public void setFileTemplateId(Integer fileTemplateId) {
		this.fileTemplateId = fileTemplateId;
	}

}
