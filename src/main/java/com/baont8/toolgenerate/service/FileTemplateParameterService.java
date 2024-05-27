package com.baont8.toolgenerate.service;

import com.baont8.toolgenerate.service.dtoRequest.fileTemplateParameter.SaveFileTemplateParameterRequestDto;
import com.baont8.toolgenerate.service.dtoResponse.fileTemplateParameter.GetParameterTypesResponseDto;

public interface FileTemplateParameterService {

	public void saveFileTemplate(SaveFileTemplateParameterRequestDto requestDto);

	public GetParameterTypesResponseDto getParameterTypes();

}
