package com.baont8.toolgenerate.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Locale;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.baont8.toolgenerate.configuration.CurrentDateConfiguration;
import com.baont8.toolgenerate.configuration.FileStoragePropertiesConfiguration;
import com.baont8.toolgenerate.entity.toolGenerate.DocumentStorage;
import com.baont8.toolgenerate.enumration.StatusEnum;
import com.baont8.toolgenerate.errors.BadRequestException;
import com.baont8.toolgenerate.errors.NotFoundException;
import com.baont8.toolgenerate.interceptor.ApiMessageInterceptor;
import com.baont8.toolgenerate.mapper.DocumentStorageMapper;
import com.baont8.toolgenerate.repository.toolGenerate.DocumentStorageRepository;
import com.baont8.toolgenerate.service.DocumentStorageService;
import com.baont8.toolgenerate.service.dtoRequest.documentStorage.UploadDocumentStorageDto;
import com.baont8.toolgenerate.service.dtoResponse.documentStorage.GetDocumentStorageResponseDto;

@Service
@Transactional
public class DocumentStorageServiceImpl implements DocumentStorageService {

	@Autowired
	private DocumentStorageRepository documentStorageRepository;

	@Autowired
	private CurrentDateConfiguration currentDateConfiguration;

	@Autowired
	private MessageSource messageSource;

	private final Path fileStorageLocation;

	public DocumentStorageServiceImpl(FileStoragePropertiesConfiguration fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {}
    }

	@Override
	public GetDocumentStorageResponseDto uploadDocument(UploadDocumentStorageDto uploadDocumentStorageDto) {
		try {
            // Get MultipartFile file
            MultipartFile multipartFile = uploadDocumentStorageDto.getMultipartFile();

            DocumentStorage documentStorage;

            // Retrieve file information
            String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
            String fileNameRandom = UUID.randomUUID().toString() + "." + extension;
            String fileName = StringUtils.cleanPath(fileNameRandom);

            // Check file name contain special characters
            if (fileName.contains("..")) {
                throw new BadRequestException(messageSource.getMessage("data_invalid", new Object[] {"DOCUMENT_STORAGE"},  new Locale(ApiMessageInterceptor.langCode)),
    	                "DOCUMENT STORAGE ENTITY");
            }

            // Copy file to location (replace file if exists)
            Path targetLocation = this.fileStorageLocation.resolve(currentDateConfiguration.informationDateSaveFile());
            Path targetLocationFile = targetLocation.resolve(fileName);

            // Create a directory to saving file
            if (!Files.exists(targetLocation)) {
                try {
                    Files.createDirectories(targetLocation);
                } catch (IOException e) {
                    // fail to create directory
                    throw new BadRequestException("ERROR CREATE DIRECTORY TO SAVE FILE", "DOCUMENT STORAGE ENTITY");
                }
            }
            Files.copy(multipartFile.getInputStream(), targetLocationFile, StandardCopyOption.REPLACE_EXISTING);

            // Set information file to Entity
            documentStorage = new DocumentStorage();
            documentStorage.setExtension(extension);
            documentStorage.setOriginalName(multipartFile.getOriginalFilename());
            documentStorage.setName(fileNameRandom);
            documentStorage.setPath(
                    "/" + currentDateConfiguration.informationDateSaveFile() + "/" + documentStorage.getName());
            documentStorage.setSize(multipartFile.getSize());

            // Saving document storage
            documentStorageRepository.save(documentStorage);

            // Return DTO
            return DocumentStorageMapper.INSTANCE.toDto(documentStorage);
        } catch (Exception e) {
        	throw new BadRequestException("ERROR SAVE FILE", "DOCUMENT STORAGE ENTITY");
        }
	}

	@Override
	public DocumentStorage getDocumentStoreById(Long id) {
		// TODO Auto-generated method stub
		return documentStorageRepository.findOneByIdAndStatus(id, StatusEnum.USING)
				.orElseThrow(() -> new BadRequestException(messageSource.getMessage("data_not_found", new Object[] {"DOCUMENT_STORAGE_ID"},  new Locale(ApiMessageInterceptor.langCode)),
	                "DOCUMENT STORAGE ENTITY", "ID")
		);
	}

	@Override
	public Resource loadFileAsResource(String pathFile) {
		// Get path
        Path filePath = this.fileStorageLocation.resolve(pathFile.substring(1, pathFile.length())).normalize();
        Resource resource = null;
        try {
            // Get resource by path
            resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
            	throw new NotFoundException(messageSource.getMessage("data_not_found", new Object[] {"ID"}, new Locale(ApiMessageInterceptor.langCode)), "DOCUMENT STORAGE ENTITY", "ID");
            }
        } catch (Exception e) {
            throw new NotFoundException(messageSource.getMessage("data_not_found", new Object[] {"ID"}, new Locale(ApiMessageInterceptor.langCode)), "DOCUMENT STORAGE ENTITY", "ID");
        }
	}

}
