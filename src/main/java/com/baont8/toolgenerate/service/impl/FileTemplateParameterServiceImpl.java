package com.baont8.toolgenerate.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.baont8.toolgenerate.entity.toolGenerate.FileTemplate;
import com.baont8.toolgenerate.entity.toolGenerate.FileTemplateParameter;
import com.baont8.toolgenerate.enumration.ParameterTypeEnum;
import com.baont8.toolgenerate.enumration.StatusEnum;
import com.baont8.toolgenerate.errors.BadRequestException;
import com.baont8.toolgenerate.interceptor.ApiMessageInterceptor;
import com.baont8.toolgenerate.mapper.FileTemplateParameterMapper;
import com.baont8.toolgenerate.repository.toolGenerate.FileTemplateParamneterRepository;
import com.baont8.toolgenerate.repository.toolGenerate.FileTemplateRepository;
import com.baont8.toolgenerate.service.CommonService;
import com.baont8.toolgenerate.service.FileTemplateParameterService;
import com.baont8.toolgenerate.service.FileTemplateService;
import com.baont8.toolgenerate.service.dto.fileTemplateParameter.FileTemplateParameterDto;
import com.baont8.toolgenerate.service.dto.fileTemplateParameter.ParameterTypeDto;
import com.baont8.toolgenerate.service.dtoRequest.fileTemplateParameter.SaveFileTemplateParameterRequestDto;
import com.baont8.toolgenerate.service.dtoResponse.fileTemplateParameter.GetParameterTypesResponseDto;

import io.micrometer.common.util.StringUtils;

@Service
@Transactional
public class FileTemplateParameterServiceImpl implements FileTemplateParameterService {

	@Autowired
	private FileTemplateParamneterRepository fileTemplateParamneterRepository;

	@Autowired
	private FileTemplateRepository fileTemplateRepository;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private FileTemplateService fileTemplateService;

	@Autowired
	private CommonService commonService;

	@Override
	public void saveFileTemplate(SaveFileTemplateParameterRequestDto requestDto) {
		// Validate data
		validateSaveFileTemplateParam(requestDto);

		// Delete all data before in database
		fileTemplateParamneterRepository.hardDeleteByFileIdAndFileParamId(requestDto.getFileTemplateId(), null);

		// Save data into database
		saveFileTemplateParams(requestDto);
	}

	private void validateSaveFileTemplateParam(SaveFileTemplateParameterRequestDto requestDto) {
		// Check input object not null
		if (requestDto == null) {
			throw new BadRequestException(messageSource.getMessage("data_required", new Object[] {"REQUEST_DTO"},  new Locale(ApiMessageInterceptor.langCode)),
                    "FILE TEMPLATE PARAMETER ENTITY", "REQUEST_DTO");
		}
		// Check file template id is exists
		if (requestDto.getFileTemplateId() == null || requestDto.getFileTemplateId() < 0) {
			throw new BadRequestException(messageSource.getMessage("data_required", new Object[] {"FILE_TEMPLATE_ID"},  new Locale(ApiMessageInterceptor.langCode)),
                    "FILE TEMPLATE PARAMETER ENTITY", "FILE_TEMPLATE_ID");
		} else if (!fileTemplateRepository.existsFileTemplateByFileTemplateIdAndStatus(requestDto.getFileTemplateId(), StatusEnum.USING)) {
			// Check exists file template id
			throw new BadRequestException(messageSource.getMessage("data_not_found", new Object[] {"FILE_TEMPLATE_ID"},  new Locale(ApiMessageInterceptor.langCode)),
                    "FILE TEMPLATE PARAMETER ENTITY", "FILE_TEMPLATE_ID");
		}
		if (!CollectionUtils.isEmpty(requestDto.getFileTemplateParams())) {
			// Check required data
			boolean isValidateEmpty = requestDto.getFileTemplateParams()
					  .stream()
					  .anyMatch(item -> StringUtils.isEmpty(item.getParameterType())
							  	        || !EnumUtils.isValidEnum(ParameterTypeEnum.class, item.getParameterType())
							            || StringUtils.isEmpty(item.getParameterKey())
							            || StringUtils.isEmpty(item.getParameterDescription()) 
							            
			);
			if (isValidateEmpty) {
				throw new BadRequestException(messageSource.getMessage("data_required", new Object[] {""},  new Locale(ApiMessageInterceptor.langCode)),
	                    "FILE TEMPLATE PARAMETER ENTITY");
			}
		}
	}

	private void saveFileTemplateParams(SaveFileTemplateParameterRequestDto requestDto) {
		FileTemplate fileTemplate = fileTemplateService.findOneByIdAndThrowException(requestDto.getFileTemplateId());
		if (!CollectionUtils.isEmpty(requestDto.getFileTemplateParams())) {
			List<FileTemplateParameter> fileTmpParams = new ArrayList<>();
			for (FileTemplateParameterDto item : requestDto.getFileTemplateParams()) {
				FileTemplateParameter fileTmpParam = FileTemplateParameterMapper.INSTANCE.toEntity(item);
				fileTmpParam.setParameterDefaultValue(commonService.convertParagraphTo1LineWithSpecialCharacter(item.getParameterDefaultValue()));
				fileTmpParam.setStatus(StatusEnum.USING);
				fileTmpParam.setFileTemplate(fileTemplate);
				fileTmpParams.add(fileTmpParam);
			}
			// Save batch file template params
			fileTemplateParamneterRepository.saveAllAndFlush(fileTmpParams);
		}
	}

	@Override
	public GetParameterTypesResponseDto getParameterTypes() {
		List<ParameterTypeDto> parameterTypes = new ArrayList<>();
		// Looping stream enums
		Arrays.asList(ParameterTypeEnum.values()).stream().forEach(item -> {
			ParameterTypeDto paramDto = new ParameterTypeDto();
			paramDto.setParameterType(item.name());
			paramDto.setParameterDesc(item.getText());
			parameterTypes.add(paramDto);
		});
		GetParameterTypesResponseDto getParameterTypesDto = new GetParameterTypesResponseDto();
		getParameterTypesDto.setParameterTypes(parameterTypes);
		return getParameterTypesDto;
	}
}
