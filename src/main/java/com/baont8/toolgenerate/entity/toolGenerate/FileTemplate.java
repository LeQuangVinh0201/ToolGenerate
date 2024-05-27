package com.baont8.toolgenerate.entity.toolGenerate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

@Entity
@Table(name = "FILE_TEMPLATE")
@Audited
public class FileTemplate extends AbstractAuditingEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FILE_TEMPLATE_ID")
	private int fileTemplateId;

	@Column(name = "FILE_TEMPLATE_NAME")
	private String fileTemplateName;

	@Column(name = "FILE_TEMPLATE_EXTENSION")
	private String fileTemplateExtension;

	@Column(name = "FILE_DESCRIPTION")
	@Lob
	private String fileDescription;

	@Column(name = "FILE_CONTENT")
	@Lob
	private String fileContent;

	@Column(name = "FILE_CONTENT_FORMAT")
	@Lob
	private String fileContentFormat;

	@Column(name = "IS_FILE_SYSTEM")
	private Boolean isFileSystem = false;

	@JsonManagedReference
	@OneToMany(mappedBy = "fileTemplate", fetch = FetchType.EAGER)
	@Where(clause = "status <> 'DELETE'")
	@OrderBy("FILE_TEMPLATE_PARAMETER_ID asc, CRT_DT asc")
	private List<FileTemplateParameter> fileTemplateParameter = new ArrayList<>();

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

	public List<FileTemplateParameter> getFileTemplateParameter() {
		return fileTemplateParameter;
	}

	public void setFileTemplateParameter(List<FileTemplateParameter> fileTemplateParameter) {
		this.fileTemplateParameter = fileTemplateParameter;
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
