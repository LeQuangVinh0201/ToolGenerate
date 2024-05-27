package com.baont8.toolgenerate.controller.api.generateTool.generateDatasetAndColumnModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baont8.toolgenerate.service.GenerateDatasetAndColumnModelService;
import com.baont8.toolgenerate.service.dtoRequest.generateDatasetAndColumnModel.GenerateDatasetAndColumnModelRequestDto;
import com.baont8.toolgenerate.service.dtoResponse.generateDatasetAndColumnModel.GenerateDatasetAndColumnModelResponseDto;

import jakarta.validation.Valid;

@RestController
public class GenerateDatasetAndColumnModelApiController {

	@Autowired
	private GenerateDatasetAndColumnModelService generateDatasetAndColumnModelService;

	@PostMapping("/generate-dataset-column-model")
	public ResponseEntity<GenerateDatasetAndColumnModelResponseDto> generateDatasetAndColumnModel(@RequestBody @Valid GenerateDatasetAndColumnModelRequestDto requestDto,
			@RequestParam(name = "lang", defaultValue = "en") String lang) {
		GenerateDatasetAndColumnModelResponseDto responseDto = generateDatasetAndColumnModelService.generateDatasetAndColumnModel(requestDto);
		return ResponseEntity.ok().body(responseDto);
	}

}
