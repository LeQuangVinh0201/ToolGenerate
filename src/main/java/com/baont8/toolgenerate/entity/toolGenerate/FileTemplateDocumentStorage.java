package com.baont8.toolgenerate.entity.toolGenerate;

import org.hibernate.envers.Audited;

import com.baont8.toolgenerate.entity.toolGenerate.id.FileTemplateDocumentStorageId;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "FILE_TEMPLATE_DOCUMENT_STORAGE")
@IdClass(FileTemplateDocumentStorageId.class)
@Audited
public class FileTemplateDocumentStorage extends AbstractAuditingEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FILE_TEMPLATE_ID")
	private FileTemplate fileTemplate;

	@Id
	@ManyToOne
	@JoinColumn(name = "DOCUMENT_STORAGE_ID")
	private DocumentStorage documentStorage;

	public FileTemplate getFileTemplate() {
		return fileTemplate;
	}

	public void setFileTemplate(FileTemplate fileTemplate) {
		this.fileTemplate = fileTemplate;
	}

	public DocumentStorage getDocumentStorage() {
		return documentStorage;
	}

	public void setDocumentStorage(DocumentStorage documentStorage) {
		this.documentStorage = documentStorage;
	}

}
