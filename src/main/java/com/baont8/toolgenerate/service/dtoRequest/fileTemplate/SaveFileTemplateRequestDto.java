package com.baont8.toolgenerate.service.dtoRequest.fileTemplate;

import com.baont8.toolgenerate.enumration.CudKeyEnum;
import com.baont8.toolgenerate.service.dto.fileTemplate.FileTemplateDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaveFileTemplateRequestDto extends FileTemplateDto {

	@JsonProperty(value = "FILE_TEMPLATE_UPLOAD_ID")
	private Long fileTemplateUploadId;

	@JsonProperty(value = "CUD_KEY")
	private CudKeyEnum cudKey;

	public CudKeyEnum getCudKey() {
		return cudKey;
	}

	public void setCudKey(CudKeyEnum cudKey) {
		this.cudKey = cudKey;
	}

	public Long getFileTemplateUploadId() {
		return fileTemplateUploadId;
	}

	public void setFileTemplateUploadId(Long fileTemplateUploadId) {
		this.fileTemplateUploadId = fileTemplateUploadId;
	}

}
