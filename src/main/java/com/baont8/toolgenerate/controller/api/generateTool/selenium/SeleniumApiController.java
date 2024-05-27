package com.baont8.toolgenerate.controller.api.generateTool.selenium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baont8.toolgenerate.service.SeleniumService;
import com.baont8.toolgenerate.service.dtoRequest.selenium.GoogleTranslateRequestDto;

@RestController
@RequestMapping(path = "/selenium")
public class SeleniumApiController {

	@Autowired
	private SeleniumService seleniumService;

	@PostMapping("/translate")
	public ResponseEntity<String> generateDatasetAndColumnModel(@RequestParam(name = "lang", defaultValue = "en") String lang,
			@RequestBody GoogleTranslateRequestDto requestDto) {
		String result = seleniumService.translate(requestDto.getTextWantToTranslate()
				, requestDto.getSourceLanguage()
				, requestDto.getTargetLanguage());
		return ResponseEntity.ok().body(result);
	}

}
