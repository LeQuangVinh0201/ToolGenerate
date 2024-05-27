package com.baont8.toolgenerate.service.dtoRequest.documentStorage;

import org.springframework.web.multipart.MultipartFile;

public class UploadDocumentStorageDto {

	private MultipartFile multipartFile;

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

}
