package com.baont8.toolgenerate.service.dtoResponse.fileTemplate;

import java.util.List;

import com.baont8.toolgenerate.service.dto.documentStorage.DocumentStorageDto;
import com.baont8.toolgenerate.service.dto.fileTemplate.FileTemplateDto;
import com.baont8.toolgenerate.service.dto.fileTemplateParameter.FileTemplateParameterDto;
import com.baont8.toolgenerate.service.dto.fileTemplateParameter.FileTemplateParameterWithBlockDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetFileTemplateResponseDto extends FileTemplateDto {

	@JsonProperty("FILE_TEMPLATE_PARAMETERS")
	private List<FileTemplateParameterDto> fileTemplateParameters;

	@JsonProperty("FILE_TEMPLATE_PARAMETERS_WITH_BLOCK")
	private List<FileTemplateParameterWithBlockDto> fileTemplateParametersWithBlock;

	@JsonProperty("FILE_TEMPLATE_DOCUMENT_STORAGES")
	private List<DocumentStorageDto> fileTemplateDocumentStorages;

	public List<FileTemplateParameterDto> getFileTemplateParameters() {
		return fileTemplateParameters;
	}

	public void setFileTemplateParameters(List<FileTemplateParameterDto> fileTemplateParameters) {
		this.fileTemplateParameters = fileTemplateParameters;
	}

	public List<FileTemplateParameterWithBlockDto> getFileTemplateParametersWithBlock() {
		return fileTemplateParametersWithBlock;
	}

	public void setFileTemplateParametersWithBlock(
			List<FileTemplateParameterWithBlockDto> fileTemplateParametersWithBlock) {
		this.fileTemplateParametersWithBlock = fileTemplateParametersWithBlock;
	}

	public List<DocumentStorageDto> getFileTemplateDocumentStorages() {
		return fileTemplateDocumentStorages;
	}

	public void setFileTemplateDocumentStorages(List<DocumentStorageDto> fileTemplateDocumentStorages) {
		this.fileTemplateDocumentStorages = fileTemplateDocumentStorages;
	}

}
