package com.baont8.toolgenerate.service.dto.fileTemplateParameter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileTemplateParameterDto {

	@JsonProperty(value = "FILE_TEMPLATE_PARAMETER_ID")
	private Integer fileTemplateParameterId;

	@JsonProperty(value = "PARAMETER_KEY")
	private String parameterKey;

	@JsonProperty(value = "PARAMETER_TYPE")
	private String parameterType;

	@JsonProperty(value = "PARAMETER_DESCRIPTION")
	private String parameterDescription;

	@JsonProperty(value = "BELONG_TO_THE_BLOCK")
	private String belongToTheBlock;

	@JsonProperty(value = "PARAMETER_VALUE")
	private String parameterValue;

	@JsonProperty(value = "PARAMETER_DEFAULT_VALUE")
	private String parameterDefaultValue;

	@JsonProperty(value = "PARAMETER_REQUIRED")
	private boolean parameterRequired = false;

	@JsonProperty(value = "IS_OPEN")
	private Boolean isOpen = true;

	public Integer getFileTemplateParameterId() {
		return fileTemplateParameterId;
	}

	public void setFileTemplateParameterId(Integer fileTemplateParameterId) {
		this.fileTemplateParameterId = fileTemplateParameterId;
	}

	public String getParameterKey() {
		return parameterKey;
	}

	public void setParameterKey(String parameterKey) {
		this.parameterKey = parameterKey;
	}

	public String getParameterType() {
		return parameterType;
	}

	public void setParameterType(String parameterType) {
		this.parameterType = parameterType;
	}

	public String getParameterDescription() {
		return parameterDescription;
	}

	public void setParameterDescription(String parameterDescription) {
		this.parameterDescription = parameterDescription;
	}

	public String getBelongToTheBlock() {
		return belongToTheBlock;
	}

	public void setBelongToTheBlock(String belongToTheBlock) {
		this.belongToTheBlock = belongToTheBlock;
	}

	public String getParameterValue() {
		return parameterValue;
	}

	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}

	public String getParameterDefaultValue() {
		return parameterDefaultValue;
	}

	public void setParameterDefaultValue(String parameterDefaultValue) {
		this.parameterDefaultValue = parameterDefaultValue;
	}

	public boolean isParameterRequired() {
		return parameterRequired;
	}

	public void setParameterRequired(boolean parameterRequired) {
		this.parameterRequired = parameterRequired;
	}

	public Boolean getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}

}
