package com.baont8.toolgenerate.controller.api.generateTool.generateFileNameSql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baont8.toolgenerate.service.GenerateFileNameSqlService;
import com.baont8.toolgenerate.service.dtoRequest.generateFileNameSql.GenerateFileNameSqlRequestDto;

import jakarta.validation.Valid;

@RestController
public class GenerateFileNameSqlApiController {

	@Autowired
	private GenerateFileNameSqlService generateFileNameSqlService;

	@PostMapping("/generate-file-name-sql")
	public ResponseEntity<String> generateFileNameSql(@RequestBody @Valid GenerateFileNameSqlRequestDto requestDto,
			@RequestParam(name = "lang", defaultValue = "en") String lang) {
		return ResponseEntity.ok().body(generateFileNameSqlService.generateFileNameSqlService(requestDto));
	}

}
