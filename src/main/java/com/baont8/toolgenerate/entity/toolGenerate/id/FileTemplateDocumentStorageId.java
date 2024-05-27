package com.baont8.toolgenerate.entity.toolGenerate.id;

import java.io.Serializable;

public class FileTemplateDocumentStorageId implements Serializable {

	private static final long serialVersionUID = 1L;

	private int fileTemplate;

	private long documentStorage;

	public FileTemplateDocumentStorageId() {
		super();
	}

	public FileTemplateDocumentStorageId(int fileTemplate, long documentStorage) {
		super();
		this.fileTemplate = fileTemplate;
		this.documentStorage = documentStorage;
	}

	public int getFileTemplate() {
		return fileTemplate;
	}

	public void setFileTemplate(int fileTemplate) {
		this.fileTemplate = fileTemplate;
	}

	public long getDocumentStorage() {
		return documentStorage;
	}

	public void setDocumentStorage(long documentStorage) {
		this.documentStorage = documentStorage;
	}

}
