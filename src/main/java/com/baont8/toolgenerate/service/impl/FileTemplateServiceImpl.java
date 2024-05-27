package com.baont8.toolgenerate.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.baont8.toolgenerate.constrant.PageableConstrants;
import com.baont8.toolgenerate.entity.toolGenerate.FileTemplate;
import com.baont8.toolgenerate.entity.toolGenerate.FileTemplateDocumentStorage;
import com.baont8.toolgenerate.entity.toolGenerate.FileTemplateParameter;
import com.baont8.toolgenerate.enumration.CudKeyEnum;
import com.baont8.toolgenerate.enumration.ParameterTypeEnum;
import com.baont8.toolgenerate.enumration.StatusEnum;
import com.baont8.toolgenerate.errors.BadRequestException;
import com.baont8.toolgenerate.errors.ValidateError;
import com.baont8.toolgenerate.errors.ValidationErrorException;
import com.baont8.toolgenerate.interceptor.ApiMessageInterceptor;
import com.baont8.toolgenerate.mapper.DocumentStorageMapper;
import com.baont8.toolgenerate.mapper.FileTemplateMapper;
import com.baont8.toolgenerate.mapper.FileTemplateParameterMapper;
import com.baont8.toolgenerate.repository.toolGenerate.FileTemplateDocumentStorageRepository;
import com.baont8.toolgenerate.repository.toolGenerate.FileTemplateRepository;
import com.baont8.toolgenerate.service.CommonService;
import com.baont8.toolgenerate.service.DocumentStorageService;
import com.baont8.toolgenerate.service.FileTemplateService;
import com.baont8.toolgenerate.service.dto.documentStorage.DocumentStorageDto;
import com.baont8.toolgenerate.service.dto.fileTemplateParameter.FileTemplateParameterDto;
import com.baont8.toolgenerate.service.dto.fileTemplateParameter.FileTemplateParameterWithBlockDto;
import com.baont8.toolgenerate.service.dtoRequest.fileTemplate.GenerateFileTemplateRequestDto;
import com.baont8.toolgenerate.service.dtoRequest.fileTemplate.GetFileTemplateRequestDto;
import com.baont8.toolgenerate.service.dtoRequest.fileTemplate.GetListFileTemplateRequestDto;
import com.baont8.toolgenerate.service.dtoRequest.fileTemplate.SaveFileTemplateRequestDto;
import com.baont8.toolgenerate.service.dtoRequest.fileTemplate.SetFileSystemRequestDto;
import com.baont8.toolgenerate.service.dtoResponse.fileTemplate.GetFileTemplateResponseDto;
import com.baont8.toolgenerate.service.dtoResponse.fileTemplate.GetListFileTemplateResponseDto;
import com.baont8.toolgenerate.service.dtoResponse.fileTemplate.SaveFileTemplateResponseDto;

@Service
public class FileTemplateServiceImpl implements FileTemplateService {

	@Autowired
	private FileTemplateRepository fileTemplateRepository;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private CommonService commonService;

	@Autowired
	private DocumentStorageService documentStorageService;

	@Autowired
	private FileTemplateDocumentStorageRepository fileDocumentStorageRepository;

	@Override
	@Transactional
	public SaveFileTemplateResponseDto saveFileTemplate(SaveFileTemplateRequestDto requestDto) {
		// Validate save file template
		validateSaveFileTemplate(requestDto);

		// DAO save file template
		requestDto.setStatus(StatusEnum.USING);
		requestDto.setFileContent(commonService.convertParagraphTo1LineWithSpecialCharacter(requestDto.getFileContent()));

		// Save File template
		FileTemplate fileTemplate = fileTemplateRepository.save(FileTemplateMapper.INSTANCE.toEntity(requestDto));

		// Hard delele old file before save
		fileDocumentStorageRepository.hardDeleteByFileIdAndDocumentStorageId(fileTemplate.getFileTemplateId(), null);
		if (requestDto.getFileTemplateUploadId() != null) {
			// Save file template document storage
			FileTemplateDocumentStorage fileDocumentStorage = new FileTemplateDocumentStorage();
			fileDocumentStorage.setFileTemplate(fileTemplate);
			fileDocumentStorage.setDocumentStorage(documentStorageService.getDocumentStoreById(requestDto.getFileTemplateUploadId()));
			fileDocumentStorageRepository.save(fileDocumentStorage);
		}
		
		// Mapping data from entity to dto
		return FileTemplateMapper.INSTANCE.toSaveSaveFileTemplateResponseDto(fileTemplate);
	}

	private void validateSaveFileTemplate(SaveFileTemplateRequestDto requestDto) {
		List<ValidateError> errors = new ArrayList<>();
        
		// Check duplicate
		if (requestDto.getCudKey() != null && requestDto.getCudKey().equals(CudKeyEnum.UPDATE)) {
			// errors.add(new ValidateError("duAnId", messageSource.getMessage("data_required", new Object[] {"MSG_CD"}, null, new Locale(ApiMessageInterceptor.langCode))));
			if (!fileTemplateRepository.existsFileTemplateByFileTemplateIdAndStatus(requestDto.getFileTemplateId(), StatusEnum.USING)) {
				errors.add(new ValidateError("FILE_TEMPLATE_ID", messageSource.getMessage("data_not_found", new Object[] {"file template id"}, new Locale(ApiMessageInterceptor.langCode))));
			}
		}
		// Check blank file template name
		if (checkBlank(requestDto.getFileTemplateName())) {
			errors.add(new ValidateError("FILE_TEMPLATE_NAME", messageSource.getMessage("data_required", new Object[] {"file template name"}, new Locale(ApiMessageInterceptor.langCode))));
		}
		// Check blank file template extension
		if (checkBlank(requestDto.getFileTemplateExtension())) {
			errors.add(new ValidateError("FILE_TEMPLATE_EXTENSION", messageSource.getMessage("data_required", new Object[] {"file template extension"}, new Locale(ApiMessageInterceptor.langCode))));
		} else if (!Pattern.compile("^\\.[\\w]+$").matcher(requestDto.getFileTemplateExtension()).matches()) {
			errors.add(new ValidateError("FILE_TEMPLATE_EXTENSION", messageSource.getMessage("data_invalid", new Object[] {"file template extension"}, new Locale(ApiMessageInterceptor.langCode))));
		}
		// Check blank file template description
		if (checkBlank(requestDto.getFileDescription())) {
			errors.add(new ValidateError("FILE_DESCRIPTION", messageSource.getMessage("data_required", new Object[] {"file description"}, new Locale(ApiMessageInterceptor.langCode))));
		}
		// Check blank file template content
		if (checkBlank(requestDto.getFileContent())) {
			errors.add(new ValidateError("FILE_CONTENT", messageSource.getMessage("data_required", new Object[] {"file content"}, new Locale(ApiMessageInterceptor.langCode))));
		}
		if (!CollectionUtils.isEmpty(errors)) {
			throw new ValidationErrorException("FILE TEMPLATE ENTITY", errors);
		}
	}

	private boolean checkBlank(String checkString) {
		return StringUtils.isBlank(checkString) ? true : false;
	}

	@Override
	public FileTemplate findOneByIdAndThrowException(Integer fileTemplateId) {
		// TODO Auto-generated method stub
		return fileTemplateRepository.findOneByFileTemplateIdAndStatus(fileTemplateId, StatusEnum.USING)
				.orElseThrow(() -> new BadRequestException(messageSource.getMessage("data_not_found", new Object[] {"FILE_TEMPLATE_ID"},  new Locale(ApiMessageInterceptor.langCode)),
                    "FILE TEMPLATE ENTITY", "FILE_TEMPLATE_ID")
		);
	}

	@Override
	public GetFileTemplateResponseDto getFileTemplateById(GetFileTemplateRequestDto requestDto) {
		// Get file template by id and throw exception if not exists
		FileTemplate fileTemplate = findOneByIdAndThrowException(requestDto.getFileTemplateId());
		// Mapping data from entity to dto
		GetFileTemplateResponseDto getFileTmpResDto = FileTemplateMapper.INSTANCE.toGetFileTemplateResponseDto(fileTemplate);
		// Setting list file parameters
		List<FileTemplateParameterDto> fileTemplateParametersDtos = FileTemplateParameterMapper.INSTANCE.fileTemplateParams(fileTemplate.getFileTemplateParameter());
		for (FileTemplateParameterDto fileTemplateParameterDto : fileTemplateParametersDtos) {
			fileTemplateParameterDto.setParameterDefaultValue(commonService.convert1LineToParagraph(fileTemplateParameterDto.getParameterDefaultValue()));
		}
		getFileTmpResDto.setFileTemplateParameters(fileTemplateParametersDtos);
		
		// Setting list file parameters with in block
		getFileTmpResDto.setFileTemplateParametersWithBlock(fileParametersWithBlock(fileTemplate.getFileTemplateParameter()));

		// Setting file template document storages
		getFileTmpResDto.setFileTemplateDocumentStorages(fileTemplateDocumentStorages(fileTemplate.getFileTemplateId()));
		return getFileTmpResDto;
	}

	private List<FileTemplateParameterWithBlockDto> fileParametersWithBlock(List<FileTemplateParameter> fileTemplateParameter) {
		if (CollectionUtils.isEmpty(fileTemplateParameter)) {
			return null;
		}
		List<FileTemplateParameterWithBlockDto> fileParamsWithBlock = new ArrayList<>();
		// Filter params is BLOCK
		List<FileTemplateParameter> paramsBlock = fileTemplateParameter
													.stream()
													.filter(item -> item.getParameterType() == ParameterTypeEnum.BLOCK)
													.collect(Collectors.toList());
		// Filter params is PARAMETER
		List<FileTemplateParameter> paramsParameter = fileTemplateParameter
													.stream()
													.filter(item -> item.getParameterType() == ParameterTypeEnum.PARAM)
													.collect(Collectors.toList());
		// filer params is PARAMETER and not belong to any block
		List<FileTemplateParameter> paramsParameterNotBelongBlock = 
				paramsParameter.stream().filter(item -> (item.getParameterType() == ParameterTypeEnum.PARAM) && StringUtils.isEmpty(item.getBelongToTheBlock()))
							   .collect(Collectors.toList());
		// Handle param not belong any block
		if (!CollectionUtils.isEmpty(paramsParameterNotBelongBlock)) {
			FileTemplateParameterWithBlockDto paramWithoutBlock = new FileTemplateParameterWithBlockDto();
			paramWithoutBlock.setParameterKey(null);

			// Set list child parameter belong to this block
			List<FileTemplateParameterWithBlockDto> fileTemplateDtoWithBlocks = 
					FileTemplateParameterMapper.INSTANCE.fileTempParamsWithBlock(paramsParameterNotBelongBlock);
			for (FileTemplateParameterWithBlockDto fileTemplateParameterWithBlockDto : fileTemplateDtoWithBlocks) {
				fileTemplateParameterWithBlockDto.setParameterDefaultValue(commonService.convert1LineToParagraph(fileTemplateParameterWithBlockDto.getParameterDefaultValue()));
			}
			paramWithoutBlock.setFileTemplateParameters(fileTemplateDtoWithBlocks);

			// Adding block
			fileParamsWithBlock.add(paramWithoutBlock);
		}
		if (!CollectionUtils.isEmpty(paramsBlock)) {
			for (FileTemplateParameter paramBlock : paramsBlock) {
				// Mapping data entity to dto
				FileTemplateParameterWithBlockDto paramBlockDto = FileTemplateParameterMapper.INSTANCE.fileTempParamWithBlock(paramBlock);
				
				// Get list child of block
				List<FileTemplateParameter> fileTempParams = 
						paramsParameter.stream().filter(param -> (param.getBelongToTheBlock() != null 
													   && param.getBelongToTheBlock().equalsIgnoreCase(paramBlockDto.getParameterKey())))
									   .collect(Collectors.toList());
				// Set list child parameter belong to this block
				List<FileTemplateParameterWithBlockDto> fileTemplateDtoWithBlocks2 = 
						FileTemplateParameterMapper.INSTANCE.fileTempParamsWithBlock(fileTempParams);
				for (FileTemplateParameterWithBlockDto fileTemplateParameterWithBlockDto : fileTemplateDtoWithBlocks2) {
					fileTemplateParameterWithBlockDto.setParameterDefaultValue(commonService.convert1LineToParagraph(fileTemplateParameterWithBlockDto.getParameterDefaultValue()));
				}
				paramBlockDto.setFileTemplateParameters(fileTemplateDtoWithBlocks2);

				// Adding block
				fileParamsWithBlock.add(paramBlockDto);
			}
		}

		return fileParamsWithBlock;
	}

	@Override
	public Resource generateFileTemplate(GenerateFileTemplateRequestDto requestDto) {
		// Build file and save file to local disc. After that return path
		try {
			// Validate info file template
	 		FileTemplate fileTemplate = findOneByIdAndThrowException(requestDto.getFileTemplateId());

	 		// Generate file template to string
	 		String fileContent = generateFileTemplateToString(requestDto);

			String pathSavedFile = commonService.buildAndSaveFileString(
					StringUtils.stripAccents(fileTemplate.getFileTemplateName())
							   .concat("_")
							   .concat((new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")).format(Calendar.getInstance().getTime()))
							   .concat(fileTemplate.getFileTemplateExtension())
							   .replaceAll("\\s+", "_")
					, fileContent
			);

			return commonService.loadFileAsResource(pathSavedFile);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BadRequestException(messageSource.getMessage("data_not_found", new Object[] {"FILE_TEMPLATE_ID"},  new Locale(ApiMessageInterceptor.langCode)),
                    "FILE TEMPLATE ENTITY", "FILE_TEMPLATE_ID");
		}
	}

	private String handleBlock(String fileTemplate, List<FileTemplateParameterDto> paramBlocks) {
		for (FileTemplateParameterDto paramBlock : paramBlocks) {
			paramBlock.getFileTemplateParameterId();
			paramBlock.getParameterType();
			paramBlock.getBelongToTheBlock();
			paramBlock.getParameterKey();
			paramBlock.getParameterValue();
			paramBlock.getParameterDescription();
			
			// If check block = false then handle replace empty code in block
			if (commonService.checkStringIsBoolean(paramBlock.getParameterValue())
					&& !BooleanUtils.toBoolean(paramBlock.getParameterValue())) {
				fileTemplate = fileTemplate.replaceAll("[\\\\n\\\\r\\\\t]*" + paramBlock.getParameterKey() + ".*?" + paramBlock.getParameterKey(), StringUtils.EMPTY);
			} else {
				fileTemplate = fileTemplate.replaceAll("[\\\\n\\\\r\\\\t]*" + paramBlock.getParameterKey(), StringUtils.EMPTY);
			}
		}
		

		return fileTemplate;
	}

	private String handleParameter(String fileTemplate, List<FileTemplateParameterDto> paramParameters) {
		for (FileTemplateParameterDto paramParameter : paramParameters) {
			paramParameter.getFileTemplateParameterId();
			paramParameter.getParameterType();
			paramParameter.getBelongToTheBlock();
			paramParameter.getParameterKey();
			paramParameter.getParameterValue();
			paramParameter.getParameterDescription();
			
			fileTemplate = fileTemplate.replaceAll(paramParameter.getParameterKey(), Matcher.quoteReplacement(paramParameter.getParameterValue()));
		}
		return fileTemplate;
	}

	@Override
	public Page<GetListFileTemplateResponseDto> getListFileTemplate(GetListFileTemplateRequestDto requestDto) {
		// Fetch data
		Page<FileTemplate>  pageFileTemplate;
		// Check fetch show all
		if (requestDto.getSizeCheckShowAll() != null && PageableConstrants.DEFAULT_SIZE_SHOW_ALL.equals(requestDto.getSizeCheckShowAll())) {
			pageFileTemplate = new PageImpl<>(new ArrayList(
					fileTemplateRepository.findAllFileTemplateUnPaging(requestDto.getStatus().name()))
			);
        } else {
        	pageFileTemplate = fileTemplateRepository.findAllFileTemplateWithPaging(requestDto.getPageable(), requestDto.getStatus().name());
        }

		// Create new object 
		List<GetListFileTemplateResponseDto> listFileTemplateResponseDto = new ArrayList<>();
		if (pageFileTemplate != null && !pageFileTemplate.isEmpty()) {
			listFileTemplateResponseDto = FileTemplateMapper.INSTANCE.toListDto(pageFileTemplate.getContent());
        } else {
        	pageFileTemplate = new PageImpl<>(new ArrayList<>());
        }
		
		return new PageImpl<>(listFileTemplateResponseDto, pageFileTemplate.getPageable(), pageFileTemplate.getTotalElements());
	}

	@Override
	public void deleteFileTemplate(int fileTemplateId) {
		FileTemplate fileTemplate = findOneByIdAndThrowException(fileTemplateId);
		if (fileTemplate.getIsFileSystem() != null && fileTemplate.getIsFileSystem() == true) {
			throw new BadRequestException(messageSource.getMessage("data_is_system", new Object[] {"FILE_TEMPLATE"},  new Locale(ApiMessageInterceptor.langCode)),
                    "FILE TEMPLATE ENTITY", "FILE_TEMPLATE_ID");
		}
		fileTemplate.setStatus(StatusEnum.DELETE);
		fileTemplateRepository.saveAndFlush(fileTemplate);
	}

	private List<DocumentStorageDto> fileTemplateDocumentStorages(int fileTemplateId) {
		List<DocumentStorageDto> documentStorageDtos = new ArrayList<>();
		List<FileTemplateDocumentStorage> documentStorages = fileDocumentStorageRepository.findAllDocumentStorageByFileTemplateFileTemplateId(fileTemplateId);
		for (FileTemplateDocumentStorage fileTemplageDocumentStorage : documentStorages) {
			documentStorageDtos.add(DocumentStorageMapper.INSTANCE.toDto(fileTemplageDocumentStorage.getDocumentStorage()));
		}
		return documentStorageDtos;
	}

	@Override
	public String generateFileTemplateToString(GenerateFileTemplateRequestDto requestDto) {
		// Validate info file template
 		FileTemplate fileTemplate = findOneByIdAndThrowException(requestDto.getFileTemplateId());

		// String content file template
		String fileContent = fileTemplate.getFileContent();

		// List param all
		List<FileTemplateParameterDto> fileTemplateParameters = requestDto.getFileTemplateParameters();

		if (!CollectionUtils.isEmpty(fileTemplateParameters)) {
			// Handle BLOCK
			// List param type BLOCK
			List<FileTemplateParameterDto> parametersBlock = fileTemplateParameters.stream().filter(item -> item.getParameterType().equalsIgnoreCase(ParameterTypeEnum.BLOCK.name()))
								  .collect(Collectors.toList());
			fileContent = handleBlock(fileContent, parametersBlock);

			// Handle PARAMETER
			// List param type PARAMETER
			List<FileTemplateParameterDto> parametersParam = fileTemplateParameters.stream().filter(item -> item.getParameterType().equalsIgnoreCase(ParameterTypeEnum.PARAM.name()))
					  .collect(Collectors.toList());
			fileContent = handleParameter(fileContent, parametersParam);
		}

		// Handle convert 1 line with spectial character /t /n /r to paragraph file code
		return commonService.convert1LineToParagraph(fileContent);
	}

	@Override
	public void setFileSystem(SetFileSystemRequestDto requestDto) {
		// Get file template
		FileTemplate fileTemplate = findOneByIdAndThrowException(requestDto.getFileTemplateId());

		// Set file template system
		fileTemplate.setIsFileSystem(requestDto.isFileSystem());

		// Save
		fileTemplateRepository.save(fileTemplate);
	}
}
