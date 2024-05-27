package com.baont8.toolgenerate.service;

import com.baont8.toolgenerate.service.dtoRequest.screen.SaveScreenRequestDto;
import com.baont8.toolgenerate.service.dtoResponse.screen.SaveScreenResponseDto;

public interface ScreenService {

	public SaveScreenResponseDto saveScreen(SaveScreenRequestDto requestDto);

	
}
