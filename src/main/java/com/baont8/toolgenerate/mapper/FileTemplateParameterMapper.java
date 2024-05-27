package com.baont8.toolgenerate.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.baont8.toolgenerate.entity.toolGenerate.FileTemplateParameter;
import com.baont8.toolgenerate.service.dto.fileTemplateParameter.FileTemplateParameterDto;
import com.baont8.toolgenerate.service.dto.fileTemplateParameter.FileTemplateParameterWithBlockDto;

@Mapper
public interface FileTemplateParameterMapper {

	FileTemplateParameterMapper INSTANCE = Mappers.getMapper(FileTemplateParameterMapper.class);

	@Mapping(target = "belongToTheBlock", expression = "java(dto.getBelongToTheBlock() == null || dto.getBelongToTheBlock().isEmpty() ? null : dto.getBelongToTheBlock())")
	void toEntity(FileTemplateParameterDto dto, @MappingTarget FileTemplateParameter fileTemplateParam);

	@Mapping(target = "crtDt", ignore = true)
	@Mapping(target = "updtDt", ignore = true)
	@Mapping(target = "belongToTheBlock", expression = "java(dto.getBelongToTheBlock() == null || dto.getBelongToTheBlock().isEmpty() ? null : dto.getBelongToTheBlock())")
	FileTemplateParameter toEntity(FileTemplateParameterDto dto);

	List<FileTemplateParameterDto> fileTemplateParams(List<FileTemplateParameter> fileTemplateParams);

	@Mapping(target = "belongToTheBlock", expression = "java(fileTemplateParameter.getBelongToTheBlock() == null || fileTemplateParameter.getBelongToTheBlock().isEmpty() ? null : fileTemplateParameter.getBelongToTheBlock())")
	FileTemplateParameterWithBlockDto fileTempParamWithBlock(FileTemplateParameter fileTemplateParameter);

	List<FileTemplateParameterWithBlockDto> fileTempParamsWithBlock(List<FileTemplateParameter> fileTemplateParameters);

}
