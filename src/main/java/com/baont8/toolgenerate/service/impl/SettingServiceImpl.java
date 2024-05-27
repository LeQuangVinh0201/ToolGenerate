package com.baont8.toolgenerate.service.impl;

import java.util.Locale;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.baont8.toolgenerate.entity.toolGenerate.FileTemplate;
import com.baont8.toolgenerate.entity.toolGenerate.Setting;
import com.baont8.toolgenerate.enumration.SettingEnum;
import com.baont8.toolgenerate.enumration.StatusEnum;
import com.baont8.toolgenerate.errors.BadRequestException;
import com.baont8.toolgenerate.interceptor.ApiMessageInterceptor;
import com.baont8.toolgenerate.repository.toolGenerate.SettingRepository;
import com.baont8.toolgenerate.service.CommonService;
import com.baont8.toolgenerate.service.FileTemplateService;
import com.baont8.toolgenerate.service.SettingService;
import com.baont8.toolgenerate.service.dtoRequest.setting.SettingFileCreMessageHrRequestDto;
import com.baont8.toolgenerate.service.dtoRequest.setting.SettingFileCreMessageNextHrRequestDto;

@Service
public class SettingServiceImpl implements SettingService {

	private final Logger log = LoggerFactory.getLogger(SettingServiceImpl.class);

	@Autowired
	private CommonService commonService;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private FileTemplateService fileTemplateService;

	@Autowired
	private SettingRepository settingRepository;

	public void settingFileTemplateToCreateCmMessageForNextHrCore(SettingFileCreMessageNextHrRequestDto requestDto) {
		// Check exists fileTemplate
		FileTemplate fileTemplate = fileTemplateService.findOneByIdAndThrowException(requestDto.getFileTemplateId());

		// Setting
		Setting setting = 
				settingRepository.findOneByCodeAndStatus(SettingEnum.FILE_TEMPLATE_TO_CREATE_CM_MESSAGE_FOR_NEXTHR_CORE, StatusEnum.USING)
				.orElse(new Setting(SettingEnum.FILE_TEMPLATE_TO_CREATE_CM_MESSAGE_FOR_NEXTHR_CORE));
		setting.setValue(String.valueOf(fileTemplate.getFileTemplateId()));
		settingRepository.save(setting);
	}

	@Override
	public void settingFileTemplateToCreateCmMessageForHrCore(SettingFileCreMessageHrRequestDto requestDto) {
		// Check exists fileTemplate
		FileTemplate fileTemplate = fileTemplateService.findOneByIdAndThrowException(requestDto.getFileTemplateId());

		// Setting
		Setting setting = 
				settingRepository.findOneByCodeAndStatus(SettingEnum.FILE_TEMPLATE_TO_CREATE_CM_MESSAGE_FOR_HR_CORE, StatusEnum.USING)
				.orElse(new Setting(SettingEnum.FILE_TEMPLATE_TO_CREATE_CM_MESSAGE_FOR_HR_CORE));
		setting.setValue(String.valueOf(fileTemplate.getFileTemplateId()));
		settingRepository.save(setting);
	}

	@Override
	public Setting findOneByCodeAndThrowExceptionIfNotExists(SettingEnum code) {
		return settingRepository.findOneByCodeAndStatus(code, StatusEnum.USING)
				.orElseThrow(() -> new BadRequestException(messageSource.getMessage("data_not_found", new Object[] {"CODE"},  new Locale(ApiMessageInterceptor.langCode)),
                    "SETTING ENTITY", "CODE")
		);
	}

	@Override
	public Setting findOneByCode(SettingEnum code) {
		return settingRepository.findOneByCodeAndStatus(code, StatusEnum.USING).orElse(null);
	}

}
