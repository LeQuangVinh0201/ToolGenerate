package com.baont8.toolgenerate.service.dto.fileTemplate;

import java.time.Instant;

import com.baont8.toolgenerate.enumration.StatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FileTemplateDto {

	@JsonProperty(value = "FILE_TEMPLATE_ID")
	private int fileTemplateId;

	@JsonProperty(value = "FILE_TEMPLATE_NAME")
	private String fileTemplateName;

	@JsonProperty(value = "FILE_TEMPLATE_EXTENSION")
	private String fileTemplateExtension;

	@JsonProperty(value = "FILE_DESCRIPTION")
	private String fileDescription;

	@JsonProperty(value = "FILE_CONTENT")
	private String fileContent;

	@JsonProperty(value = "FILE_CONTENT_FORMAT")
	private String fileContentFormat;

	@JsonProperty(value = "CRT_DT")
	private Instant crtDt;

	@JsonProperty(value = "UPDT_DT")
	private Instant updtDt;

	@JsonProperty(value = "STATUS")
	private StatusEnum status;

	@JsonProperty(value = "IS_FILE_SYSTEM")
	private Boolean isFileSystem = false;

	public int getFileTemplateId() {
		return fileTemplateId;
	}

	public void setFileTemplateId(int fileTemplateId) {
		this.fileTemplateId = fileTemplateId;
	}

	public String getFileTemplateName() {
		return fileTemplateName;
	}

	public void setFileTemplateName(String fileTemplateName) {
		this.fileTemplateName = fileTemplateName;
	}

	public String getFileTemplateExtension() {
		return fileTemplateExtension;
	}

	public void setFileTemplateExtension(String fileTemplateExtension) {
		this.fileTemplateExtension = fileTemplateExtension;
	}

	public String getFileDescription() {
		return fileDescription;
	}

	public void setFileDescription(String fileDescription) {
		this.fileDescription = fileDescription;
	}

	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

	public Instant getCrtDt() {
		return crtDt;
	}

	public void setCrtDt(Instant crtDt) {
		this.crtDt = crtDt;
	}

	public Instant getUpdtDt() {
		return updtDt;
	}

	public void setUpdtDt(Instant updtDt) {
		this.updtDt = updtDt;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public String getFileContentFormat() {
		return fileContentFormat;
	}

	public void setFileContentFormat(String fileContentFormat) {
		this.fileContentFormat = fileContentFormat;
	}

	public Boolean getIsFileSystem() {
		return isFileSystem;
	}

	public void setIsFileSystem(Boolean isFileSystem) {
		this.isFileSystem = isFileSystem;
	}

}
