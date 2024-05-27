package com.baont8.toolgenerate.service.dtoRequest.fileTemplate;

import java.util.List;

import com.baont8.toolgenerate.service.dto.fileTemplate.FileTemplateDto;
import com.baont8.toolgenerate.service.dto.fileTemplateParameter.FileTemplateParameterDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GenerateFileTemplateRequestDto extends FileTemplateDto {

	@JsonProperty("FILE_TEMPLATE_PARAMETERS")
	private List<FileTemplateParameterDto> fileTemplateParameters;

	public List<FileTemplateParameterDto> getFileTemplateParameters() {
		return fileTemplateParameters;
	}

	public void setFileTemplateParameters(List<FileTemplateParameterDto> fileTemplateParameters) {
		this.fileTemplateParameters = fileTemplateParameters;
	}

}
