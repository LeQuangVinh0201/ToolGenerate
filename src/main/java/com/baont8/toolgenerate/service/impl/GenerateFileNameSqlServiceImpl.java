package com.baont8.toolgenerate.service.impl;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.baont8.toolgenerate.errors.BadRequestException;
import com.baont8.toolgenerate.interceptor.ApiMessageInterceptor;
import com.baont8.toolgenerate.service.GenerateFileNameSqlService;
import com.baont8.toolgenerate.service.dtoRequest.generateFileNameSql.GenerateFileNameSqlRequestDto;

@Service
public class GenerateFileNameSqlServiceImpl implements GenerateFileNameSqlService {

	@Autowired
	private MessageSource messageSource;

	private static final String PATTERN_BRANCH = "^(\\w)+(\\/\\w+)(-\\d+)";
	private static final String PATTERN_CODE = "(-\\d+)";
	private static final String FILE_NAME_SQL = "V${VERSION_YEAR}.${CODE}.${VERSION}__${CODE}-${BRANCH_NAME}.sql";

	@Override
	public String generateFileNameSqlService(GenerateFileNameSqlRequestDto requestDto) {
		// Validate data
		validateGenerateData(requestDto);

		// Handle generate
		return handleGenerate(requestDto);
	}

	private void validateGenerateData(GenerateFileNameSqlRequestDto requestDto) {
		if (requestDto == null || StringUtils.isBlank(requestDto.getBranchName()) 
				|| StringUtils.isBlank(requestDto.getVersion())
				|| StringUtils.isBlank(requestDto.getVersionYear())) {
			throw new BadRequestException(messageSource.getMessage("data_required", new Object[] {"REQUEST_DTO"},  new Locale(ApiMessageInterceptor.langCode)),
                    "GENERATE DATASET AND COLUMN MODEL", "REQUEST_DTO");
		}
	}

	private String handleGenerate(GenerateFileNameSqlRequestDto requestDto) {
		if (!requestDto.getBranchName().trim().matches(PATTERN_BRANCH.concat(".+"))) {
			throw new BadRequestException(messageSource.getMessage("data_invalid", new Object[] {"BRANCH_NAME_NEXTHR_CORE"},  new Locale(ApiMessageInterceptor.langCode)),
                    "GENERATE BRANCH FILE NAME SQL", "REQUEST_DTO");
		} else {
			Matcher matcher = Pattern.compile(PATTERN_BRANCH).matcher(requestDto.getBranchName().trim());
			String branchMatches = null;
			if (matcher.find()) {// if it matched the pattern
				branchMatches = matcher.group(0).trim();// the group captured by the regex
			}
			Matcher matcherCode = Pattern.compile(PATTERN_CODE).matcher(branchMatches);
			String code = null;
			if (matcherCode.find()) {// if it matched the pattern
				code = matcherCode.group(0).trim().replaceAll("-", "");// the group captured by the regex
			}
			String fileNameSql = FILE_NAME_SQL;
			return fileNameSql.replace("${VERSION_YEAR}", requestDto.getVersionYear())
					.replace("${CODE}", code)
					.replace("${VERSION}", requestDto.getVersion().trim())
					.replace("${BRANCH_NAME}", requestDto.getBranchName().trim().replaceAll("/", ""));
		}
	}
}
