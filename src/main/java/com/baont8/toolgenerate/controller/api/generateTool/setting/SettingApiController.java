package com.baont8.toolgenerate.controller.api.generateTool.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baont8.toolgenerate.service.SettingService;
import com.baont8.toolgenerate.service.dtoRequest.setting.SettingFileCreMessageHrRequestDto;
import com.baont8.toolgenerate.service.dtoRequest.setting.SettingFileCreMessageNextHrRequestDto;

import jakarta.validation.Valid;

@RestController
public class SettingApiController {

	@Autowired
	private SettingService settingService;

	@PutMapping("/setting-file-cm-message-nexthr-core")
	public ResponseEntity<Void> settingFileTemplateToCreateCmMessageForNextHRCore(@RequestBody @Valid SettingFileCreMessageNextHrRequestDto requestDto,
			@RequestParam(name = "lang", defaultValue = "en") String lang) {
		settingService.settingFileTemplateToCreateCmMessageForNextHrCore(requestDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/setting-file-cm-message-hr-core")
	public ResponseEntity<Void> settingFileTemplateToCreateCmMessageForHRCore(@RequestBody @Valid SettingFileCreMessageHrRequestDto requestDto,
			@RequestParam(name = "lang", defaultValue = "en") String lang) {
		settingService.settingFileTemplateToCreateCmMessageForHrCore(requestDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
