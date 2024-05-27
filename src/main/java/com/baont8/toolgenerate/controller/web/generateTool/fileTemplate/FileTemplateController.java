package com.baont8.toolgenerate.controller.web.generateTool.fileTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.baont8.toolgenerate.constrant.SortConstrants;
import com.baont8.toolgenerate.enumration.SettingEnum;
import com.baont8.toolgenerate.enumration.StatusEnum;
import com.baont8.toolgenerate.service.CommonService;
import com.baont8.toolgenerate.service.FileTemplateParameterService;
import com.baont8.toolgenerate.service.FileTemplateService;
import com.baont8.toolgenerate.service.SettingService;
import com.baont8.toolgenerate.service.dtoRequest.fileTemplate.GetFileTemplateRequestDto;
import com.baont8.toolgenerate.service.dtoRequest.fileTemplate.GetListFileTemplateRequestDto;
import com.baont8.toolgenerate.service.dtoResponse.fileTemplate.GetListFileTemplateResponseDto;

@Controller
public class FileTemplateController {

	@Autowired
	private FileTemplateService fileTemplateService;

	@Autowired
	private FileTemplateParameterService fileTemplateParameterService;

	@Autowired
	private CommonService commonService;

	@Autowired
	private SettingService settingService;

	@GetMapping(value = {"/file-template", "/file-template/{fileTemplateId}"})
	public String viewFileTemplateDetail(Model model, @PathVariable(name = "fileTemplateId", required = false) Integer fileTemplateId,
			@RequestParam(name = "layout", defaultValue = "false") boolean isLayout) {
		
		// Get detail file template by id if exists else new page
		if (fileTemplateId != null) {
			GetFileTemplateRequestDto fileTmpReqDto = new GetFileTemplateRequestDto();
			fileTmpReqDto.setFileTemplateId(fileTemplateId);
			model.addAttribute("infoFileTemplate", fileTemplateService.getFileTemplateById(fileTmpReqDto));
		}
		// Get list parameter type
		model.addAttribute("paramTypes", fileTemplateParameterService.getParameterTypes());
		// Get list yes no type
		model.addAttribute("ynType", commonService.getYesNoTypes());
		// Add jsp name of this screen
		model.addAttribute("jspName", "fileTemplateDetail.jsp");
		return  isLayout ? "layout" : "layout_structure";
	}

	@GetMapping(value = {"/generate-file-template/{fileTemplateId}"})
	public String viewGenerateFileTemplate(Model model, @PathVariable(name = "fileTemplateId", required = false) Integer fileTemplateId, 
			@RequestParam(name = "layout", defaultValue = "false") boolean isLayout) {
		
		// Get detail file template by id if exists else new page
		if (fileTemplateId != null) {
			GetFileTemplateRequestDto fileTmpReqDto = new GetFileTemplateRequestDto();
			fileTmpReqDto.setFileTemplateId(fileTemplateId);
			model.addAttribute("infoFileTemplate", fileTemplateService.getFileTemplateById(fileTmpReqDto));
		}
		// Get list parameter type
		model.addAttribute("paramTypes", fileTemplateParameterService.getParameterTypes());
		// Get list yes no type
		model.addAttribute("ynType", commonService.getYesNoTypes());
		// Add jsp name of this screen
		model.addAttribute("jspName", "generateFileTemplate.jsp");
		model.addAttribute("isLayout", isLayout);
		return  isLayout ? "layout" : "layout_structure";
	}

	@GetMapping(value = {"/database"})
	public String viewDatabase(Model model) {
		return "database";
	}

	@GetMapping(value = {"/file-template-group", "/file-template-group/{fileTemplateId}"})
	public String viewFileTemplateDetail1(Model model, @PathVariable(name = "fileTemplateId", required = false) Integer fileTemplateId) {
		
		// Get detail file template by id if exists else new page
		if (fileTemplateId != null) {
			GetFileTemplateRequestDto fileTmpReqDto = new GetFileTemplateRequestDto();
			fileTmpReqDto.setFileTemplateId(fileTemplateId);
			model.addAttribute("infoFileTemplate", fileTemplateService.getFileTemplateById(fileTmpReqDto));
		}
		// Get list parameter type
		model.addAttribute("paramTypes", fileTemplateParameterService.getParameterTypes());
		// Get list yes no type
		model.addAttribute("ynType", commonService.getYesNoTypes());
		// Add jsp name of this screen
		model.addAttribute("jspName", "fileTemplateDetail.jsp");
		return "demo_relashionship_file_template";
	}

	@GetMapping(value = {"/group-relationship-file-template", "/group-relationship-file-template/{fileTemplateId}"})
	public String viewGroupReplationshipFileTemplate(Model model, @PathVariable(name = "fileTemplateId", required = false) Integer fileTemplateId) {
		
		// Get detail file template by id if exists else new page
		if (fileTemplateId != null) {
			GetFileTemplateRequestDto fileTmpReqDto = new GetFileTemplateRequestDto();
			fileTmpReqDto.setFileTemplateId(fileTemplateId);
			model.addAttribute("infoFileTemplate", fileTemplateService.getFileTemplateById(fileTmpReqDto));
		}
		// Get list parameter type
		model.addAttribute("paramTypes", fileTemplateParameterService.getParameterTypes());
		// Get list yes no type
		model.addAttribute("ynType", commonService.getYesNoTypes());
		// Add jsp name of this screen
		model.addAttribute("jspName", "fileTemplateDetail.jsp");
		return "group_relationship_file_template";
	}

	@GetMapping(value = {"/", "/list-file-template"})
	public String listFileTemplate(Model model) {
		// Create object input
		GetListFileTemplateRequestDto requestDto = new GetListFileTemplateRequestDto();
		requestDto.setStatus(StatusEnum.USING);
		Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE, Sort.by(SortConstrants.CREATED_DATE_NATIVE).descending());
		requestDto.setPageable(pageable);
		// Call service query list file template
		Page<GetListFileTemplateResponseDto> pageListFileTemplate = fileTemplateService.getListFileTemplate(requestDto);
		model.addAttribute("listFileTemplate", pageListFileTemplate);
		
		return "listFileTemplate";
	}

	@GetMapping(value = "/generate-dataset-column-model")
	public String generateDataSetAndColumnModel(Model model) {
		return "generateDataSetAndColumnModel";
	}

	@GetMapping(value = "/generate-file-name-sql")
	public String generateFileNameSql(Model model) {
		return "generateFileNameSql";
	}

	@GetMapping(value = "/generate-cm-message-nexthr-core")
	public String generateDataSetAndColumnModelDevelop(Model model) {
		// Get setting cm message for NextHR Core
		model.addAttribute("settingCreateCmMessageForNextHRCore", settingService.findOneByCode(SettingEnum.FILE_TEMPLATE_TO_CREATE_CM_MESSAGE_FOR_NEXTHR_CORE));

		return "generateCmMessageForNextHRCore";
	}

	@GetMapping(value = {"/setting"})
	public String setting(Model model) {
		GetListFileTemplateRequestDto requestDto = new GetListFileTemplateRequestDto();
		requestDto.setStatus(StatusEnum.USING);
		Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE, Sort.by(SortConstrants.CREATED_DATE_NATIVE).descending());
		requestDto.setPageable(pageable);
		// Call service query list file template
		Page<GetListFileTemplateResponseDto> pageListFileTemplate = fileTemplateService.getListFileTemplate(requestDto);
		model.addAttribute("listFileTemplate", pageListFileTemplate);

		// Get setting cm message for NextHR Core
		model.addAttribute("settingCreateCmMessageForNextHRCore", settingService.findOneByCode(SettingEnum.FILE_TEMPLATE_TO_CREATE_CM_MESSAGE_FOR_NEXTHR_CORE));

		// Get setting cm message for HR Core
		model.addAttribute("settingCreateCmMessageForHRCore", settingService.findOneByCode(SettingEnum.FILE_TEMPLATE_TO_CREATE_CM_MESSAGE_FOR_HR_CORE));
		return "setting";
	}

}
