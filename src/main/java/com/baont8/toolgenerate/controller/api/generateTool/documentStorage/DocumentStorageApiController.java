package com.baont8.toolgenerate.controller.api.generateTool.documentStorage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baont8.toolgenerate.entity.toolGenerate.DocumentStorage;
import com.baont8.toolgenerate.mapper.DocumentStorageMapper;
import com.baont8.toolgenerate.service.DocumentStorageService;
import com.baont8.toolgenerate.service.dto.documentStorage.DocumentStorageDto;
import com.baont8.toolgenerate.service.dtoRequest.documentStorage.UploadDocumentStorageDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class DocumentStorageApiController {

    @Autowired
    DocumentStorageService documentStorageService;

    @PostMapping("/file/upload")
    @ResponseStatus(value = HttpStatus.CREATED)
    public DocumentStorageDto uploadDocumentStorage(
            @RequestParam("file") MultipartFile multipartFile) {

        UploadDocumentStorageDto requestDto = new UploadDocumentStorageDto();
        requestDto.setMultipartFile(multipartFile);
        return documentStorageService.uploadDocument(requestDto);
    }

    @PostMapping("/file/upload-multiple")
    @ResponseStatus(value = HttpStatus.CREATED)
    public List<DocumentStorageDto> uploadMultipleDocumentStroages(
            @RequestParam("files") MultipartFile[] multipartFiles) {

        return Arrays.asList(multipartFiles).stream().map(item -> uploadDocumentStorage(item))
                .collect(Collectors.toList());

    }

    @GetMapping("/file/{id}/download")
    public ResponseEntity<Resource> downloadFile(
            @PathVariable(required = true) Long id, HttpServletRequest request) {

        // Retrieve information document storage by id
        DocumentStorage documentStore = documentStorageService.getDocumentStoreById(id);

        // Load file as resource
        Resource resource = documentStorageService.loadFileAsResource(documentStore.getPath());

        return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping("/file/{id}")
    public DocumentStorageDto getDocumentStorageDetailById(
    		@PathVariable(required = true) Long id) {

        // Retrieve Document storage information by id
        DocumentStorage documentStorage = documentStorageService.getDocumentStoreById(id);

        // Convert Entity to Dto
        return DocumentStorageMapper.INSTANCE.toDto(documentStorage);
    }

    @GetMapping("/file")
    public List<DocumentStorageDto> getListDocumentStorageDetailByIds(
    		@RequestParam(name = "id", required = true) List<Long> ids) {

        return ids.stream()
                .map(id -> getDocumentStorageDetailById(id))
                .collect(Collectors.toList());
    }
}
