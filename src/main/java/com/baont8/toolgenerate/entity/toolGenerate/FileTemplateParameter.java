package com.baont8.toolgenerate.entity.toolGenerate;

import org.hibernate.envers.Audited;

import com.baont8.toolgenerate.enumration.ParameterTypeEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "FILE_TEMPLATE_PARAMETER")
@Audited
public class FileTemplateParameter extends AbstractAuditingEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FILE_TEMPLATE_PARAMETER_ID")
	private int fileTemplateParameterId;

	@Column(name = "PARAMETER_KEY")
	private String parameterKey;

	@Column(name = "PARAMETER_TYPE")
	@Enumerated(EnumType.STRING)
	private ParameterTypeEnum parameterType;

	@Column(name = "BELONG_TO_THE_BLOCK")
	private String belongToTheBlock;

	@Column(name = "PARAMETER_DESCRIPTION")
	private String parameterDescription;

	@Column(name = "PARAMETER_DEFAULT_VALUE")
	@Lob
	private String parameterDefaultValue;

	@Column(name = "IS_OPEN")
	private Boolean isOpen = true;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FILE_TEMPLATE_ID", nullable = false)
	private FileTemplate fileTemplate;

	@Column(name = "PARAMETER_REQUIRED")
	private Boolean parameterRequired = false;

	public int getFileTemplateParameterId() {
		return fileTemplateParameterId;
	}

	public void setFileTemplateParameterId(int fileTemplateParameterId) {
		this.fileTemplateParameterId = fileTemplateParameterId;
	}

	public String getParameterKey() {
		return parameterKey;
	}

	public void setParameterKey(String parameterKey) {
		this.parameterKey = parameterKey;
	}

	public ParameterTypeEnum getParameterType() {
		return parameterType;
	}

	public void setParameterType(ParameterTypeEnum parameterType) {
		this.parameterType = parameterType;
	}

	public String getParameterDescription() {
		return parameterDescription;
	}

	public void setParameterDescription(String parameterDescription) {
		this.parameterDescription = parameterDescription;
	}

	public FileTemplate getFileTemplate() {
		return fileTemplate;
	}

	public void setFileTemplate(FileTemplate fileTemplate) {
		this.fileTemplate = fileTemplate;
	}

	public String getBelongToTheBlock() {
		return belongToTheBlock;
	}

	public void setBelongToTheBlock(String belongToTheBlock) {
		this.belongToTheBlock = belongToTheBlock;
	}

	public String getParameterDefaultValue() {
		return parameterDefaultValue;
	}

	public void setParameterDefaultValue(String parameterDefaultValue) {
		this.parameterDefaultValue = parameterDefaultValue;
	}

	public Boolean isParameterRequired() {
		return parameterRequired;
	}

	public void setParameterRequired(Boolean parameterRequired) {
		this.parameterRequired = parameterRequired;
	}

	public Boolean getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}
}
