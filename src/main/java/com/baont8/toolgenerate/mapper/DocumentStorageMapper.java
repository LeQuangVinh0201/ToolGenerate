package com.baont8.toolgenerate.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.baont8.toolgenerate.entity.toolGenerate.DocumentStorage;
import com.baont8.toolgenerate.service.dtoResponse.documentStorage.GetDocumentStorageResponseDto;

@Mapper
public interface DocumentStorageMapper {

	DocumentStorageMapper INSTANCE = Mappers.getMapper(DocumentStorageMapper.class);

    GetDocumentStorageResponseDto toDto(DocumentStorage entity);

}
	