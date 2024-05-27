package com.baont8.toolgenerate.controller.api.projectCustomer.cmMessage;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baont8.toolgenerate.service.dtoRequest.fileTemplate.GenerateFileTemplateRequestDto;
import com.baont8.toolgenerate.service.dtoResponse.cmMessage.GetCmMessageDetailResponseDto;
import com.baont8.toolgenerate.service.projectCustomer.ProjectCustomerService;

import jakarta.validation.Valid;

@RestController
public class CmMessageApiController {

	@Autowired
	private ProjectCustomerService projectCustomerService;

	@GetMapping("/list-cm-message")
	public ResponseEntity<List<GetCmMessageDetailResponseDto>> getListCmMessage(
			@RequestParam(name = "msg", required = false) String msg,
			@RequestParam(name = "listLangCd", required = false) Set<String> listLangCd,
			@RequestParam(name = "listMsgGrp", required = false) Set<String> listMsgGrp,
			@RequestParam(name = "listMsgType", required = false) Set<String> listMsgType,
			@RequestParam(name = "listSysCd", required = false) Set<String> listSysCd,
			@RequestParam(name = "listCompCd", required = false) Set<String> listCompCd,
			@RequestParam(name = "msgCd", required = false) String msgCd) {
		List<GetCmMessageDetailResponseDto> listCmMessage = 
				projectCustomerService.getListCmMessage(msg, listLangCd, listMsgGrp, listMsgType, listSysCd, listCompCd, msgCd);
		return ResponseEntity.ok().body(listCmMessage);
	}

	@GetMapping("/check-exists-cm-message")
	public ResponseEntity<Boolean> checkExistsCmMessage(
			@RequestParam(name = "msg", required = false) String msg,
			@RequestParam(name = "listLangCd", required = false) Set<String> listLangCd,
			@RequestParam(name = "listMsgGrp", required = false) Set<String> listMsgGrp,
			@RequestParam(name = "listMsgType", required = false) Set<String> listMsgType,
			@RequestParam(name = "listSysCd", required = false) Set<String> listSysCd,
			@RequestParam(name = "listCompCd", required = false) Set<String> listCompCd,
			@RequestParam(name = "msgCd", required = false) String msgCd) {
		boolean checkExistsCmMessage = 
				projectCustomerService.checkExistsCmMessage(msg, listLangCd, listMsgGrp, listMsgType, listSysCd, listCompCd, msgCd);
		return ResponseEntity.ok().body(checkExistsCmMessage);
	}

	@PostMapping("/save-cm-message-into-nexthr-core")
	public ResponseEntity<Boolean> saveCmMessageIntoNextHrCore(@RequestBody @Valid GenerateFileTemplateRequestDto requestDto,
			@RequestParam(name = "lang", defaultValue = "en") String lang) throws Exception {
		return ResponseEntity.ok().body(projectCustomerService.saveCmMessageIntoNextHRCore(requestDto));
	}
}
