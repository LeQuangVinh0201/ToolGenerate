package com.baont8.toolgenerate.service.dtoRequest.fileTemplate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SetFileSystemRequestDto {

	@JsonIgnore
	private int fileTemplateId;

	@JsonProperty("IS_FILE_SYSTEM")
	private boolean isFileSystem;

	public int getFileTemplateId() {
		return fileTemplateId;
	}

	public void setFileTemplateId(int fileTemplateId) {
		this.fileTemplateId = fileTemplateId;
	}

	public boolean isFileSystem() {
		return isFileSystem;
	}

	public void setFileSystem(boolean isFileSystem) {
		this.isFileSystem = isFileSystem;
	}

}
