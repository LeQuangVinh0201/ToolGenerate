package com.baont8.toolgenerate.mapper;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.baont8.toolgenerate.entity.toolGenerate.FileTemplate;
import com.baont8.toolgenerate.service.dtoRequest.fileTemplate.SaveFileTemplateRequestDto;
import com.baont8.toolgenerate.service.dtoResponse.fileTemplate.GetFileTemplateResponseDto;
import com.baont8.toolgenerate.service.dtoResponse.fileTemplate.GetListFileTemplateResponseDto;
import com.baont8.toolgenerate.service.dtoResponse.fileTemplate.SaveFileTemplateResponseDto;

@Mapper
public interface FileTemplateMapper {

	FileTemplateMapper INSTANCE = Mappers.getMapper(FileTemplateMapper.class);
	
	@Mapping(target = "crtDt", ignore = true)
	@Mapping(target = "updtDt", ignore = true)
	void toEntity(SaveFileTemplateRequestDto dto, @MappingTarget FileTemplate fileTemplate);

	@Mapping(target = "crtDt", ignore = true)
	@Mapping(target = "updtDt", ignore = true)
	FileTemplate toEntity(SaveFileTemplateRequestDto dto);

	SaveFileTemplateResponseDto toSaveSaveFileTemplateResponseDto(FileTemplate fileTemplate);

	GetFileTemplateResponseDto toGetFileTemplateResponseDto(FileTemplate fileTemplate);

	List<GetListFileTemplateResponseDto> toListDto(List<FileTemplate> listFileTemplate);

	default GetListFileTemplateResponseDto toListDto(FileTemplate fileTemplate) {
		if ( fileTemplate == null ) {
            return null;
        }
		DateTimeFormatter formatter =
      		  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());

		GetListFileTemplateResponseDto getListFileTemplateResponseDto = new GetListFileTemplateResponseDto();

        getListFileTemplateResponseDto.setCrtDt( fileTemplate.getCrtDt() );
        getListFileTemplateResponseDto.setFileContent( fileTemplate.getFileContent() );
        getListFileTemplateResponseDto.setFileContentFormat( fileTemplate.getFileContentFormat() );
        getListFileTemplateResponseDto.setFileDescription( fileTemplate.getFileDescription() );
        getListFileTemplateResponseDto.setFileTemplateExtension( fileTemplate.getFileTemplateExtension() );
        getListFileTemplateResponseDto.setFileTemplateId( fileTemplate.getFileTemplateId() );
        getListFileTemplateResponseDto.setFileTemplateName( fileTemplate.getFileTemplateName() );
        getListFileTemplateResponseDto.setStatus( fileTemplate.getStatus() );
        getListFileTemplateResponseDto.setUpdtDt( fileTemplate.getUpdtDt() );

        getListFileTemplateResponseDto.setFormatCrtDt(formatter.format(fileTemplate.getCrtDt()));
        getListFileTemplateResponseDto.setFormatUpdtDt(formatter.format(fileTemplate.getUpdtDt()));
        getListFileTemplateResponseDto.setIsFileSystem(fileTemplate.getIsFileSystem());
        
        return getListFileTemplateResponseDto;
	}
}
