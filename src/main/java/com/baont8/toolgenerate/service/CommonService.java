package com.baont8.toolgenerate.service;

import java.io.IOException;

import org.springframework.core.io.Resource;

import com.baont8.toolgenerate.service.dtoResponse.common.GetYesNoTypesResponseDto;

public interface CommonService {

	public String convertParagraphTo1LineWithSpecialCharacter(String sourceString);

	public String convert1LineToParagraph(String sourceString);

	public Boolean checkStringIsBoolean(String stringBoolean);

	public String buildAndSaveFileString(String fileNameWithExtension, String fileContent) throws IOException;

	public Resource loadFileAsResource(String pathFile);

	public GetYesNoTypesResponseDto getYesNoTypes();

	public String urlEncode(String text);

}
