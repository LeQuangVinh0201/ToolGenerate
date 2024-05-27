package com.baont8.toolgenerate.service;

import org.springframework.core.io.Resource;

import com.baont8.toolgenerate.entity.toolGenerate.DocumentStorage;
import com.baont8.toolgenerate.service.dtoRequest.documentStorage.UploadDocumentStorageDto;
import com.baont8.toolgenerate.service.dtoResponse.documentStorage.GetDocumentStorageResponseDto;

public interface DocumentStorageService {

	public GetDocumentStorageResponseDto uploadDocument(UploadDocumentStorageDto uploadDocumentStorageDto);

	public DocumentStorage getDocumentStoreById(Long id);

	public Resource loadFileAsResource(String pathFile);

}
