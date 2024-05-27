package com.baont8.toolgenerate.service;

import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;

import com.baont8.toolgenerate.entity.toolGenerate.FileTemplate;
import com.baont8.toolgenerate.service.dtoRequest.fileTemplate.GenerateFileTemplateRequestDto;
import com.baont8.toolgenerate.service.dtoRequest.fileTemplate.GetFileTemplateRequestDto;
import com.baont8.toolgenerate.service.dtoRequest.fileTemplate.GetListFileTemplateRequestDto;
import com.baont8.toolgenerate.service.dtoRequest.fileTemplate.SaveFileTemplateRequestDto;
import com.baont8.toolgenerate.service.dtoRequest.fileTemplate.SetFileSystemRequestDto;
import com.baont8.toolgenerate.service.dtoResponse.fileTemplate.GetFileTemplateResponseDto;
import com.baont8.toolgenerate.service.dtoResponse.fileTemplate.GetListFileTemplateResponseDto;
import com.baont8.toolgenerate.service.dtoResponse.fileTemplate.SaveFileTemplateResponseDto;

public interface FileTemplateService {

	public SaveFileTemplateResponseDto saveFileTemplate(SaveFileTemplateRequestDto requestDto);

	public FileTemplate findOneByIdAndThrowException(Integer fileTemplateId);

	public GetFileTemplateResponseDto getFileTemplateById(GetFileTemplateRequestDto requestDto);

	public Resource generateFileTemplate(GenerateFileTemplateRequestDto requestDto);

	public String generateFileTemplateToString(GenerateFileTemplateRequestDto requestDto);

	public Page<GetListFileTemplateResponseDto> getListFileTemplate(GetListFileTemplateRequestDto requestDto);

	public void deleteFileTemplate(int fileTemplateId);

	public void setFileSystem(SetFileSystemRequestDto requestDto);

}
