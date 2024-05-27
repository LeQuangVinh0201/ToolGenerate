package com.baont8.toolgenerate.controller.api.generateTool.fileTemplateParameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baont8.toolgenerate.service.FileTemplateParameterService;
import com.baont8.toolgenerate.service.dtoRequest.fileTemplateParameter.SaveFileTemplateParameterRequestDto;
import com.baont8.toolgenerate.service.dtoResponse.fileTemplate.SaveFileTemplateResponseDto;
import com.baont8.toolgenerate.service.dtoResponse.fileTemplateParameter.GetParameterTypesResponseDto;

import jakarta.validation.Valid;

@RestController
public class FileTemplateParameterApiController {

	@Autowired
	private FileTemplateParameterService fileTemplateParameterService;

	@PostMapping("/save-file-template-params")
	public ResponseEntity<SaveFileTemplateResponseDto> saveFileTemplateParams(@RequestBody @Valid SaveFileTemplateParameterRequestDto requestDto,
			@RequestParam(name = "lang", defaultValue = "en") String lang) {
		fileTemplateParameterService.saveFileTemplate(requestDto);
		return ResponseEntity.ok().body(null);
	}

	@GetMapping("/get-parameter-types")
	public ResponseEntity<GetParameterTypesResponseDto> getParameterTypes(
			@RequestParam(name = "lang", defaultValue = "en") String lang) {
		return ResponseEntity.ok().body(fileTemplateParameterService.getParameterTypes());
	}

}
