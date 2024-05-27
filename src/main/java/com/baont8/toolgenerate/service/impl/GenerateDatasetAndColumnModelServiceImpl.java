package com.baont8.toolgenerate.service.impl;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.baont8.toolgenerate.enumration.PositionEnum;
import com.baont8.toolgenerate.errors.BadRequestException;
import com.baont8.toolgenerate.interceptor.ApiMessageInterceptor;
import com.baont8.toolgenerate.service.GenerateDatasetAndColumnModelService;
import com.baont8.toolgenerate.service.dto.generateDatasetAndColumnModel.ColumnModelDto;
import com.baont8.toolgenerate.service.dto.generateDatasetAndColumnModel.DatasetDto;
import com.baont8.toolgenerate.service.dtoRequest.generateDatasetAndColumnModel.GenerateDatasetAndColumnModelRequestDto;
import com.baont8.toolgenerate.service.dtoResponse.generateDatasetAndColumnModel.GenerateDatasetAndColumnModelResponseDto;

@Service
public class GenerateDatasetAndColumnModelServiceImpl implements GenerateDatasetAndColumnModelService {

	@Autowired
	private MessageSource messageSource;

	// private static final String FORMAT_STRING_DATASET = "{ ${COLUMN_ID} - ${COLUMN_TYPE} - ${COLUMN_DESCRIPTION} }";
	private static final String FORMAT_STRING_DATASET = "{ id: '${COLUMN_ID}', type: '${COLUMN_TYPE}' }";
	private static final String FORMAT_STRING_COLUMN_MODEL = "{\n\tfield:  '${COLUMN_ID}', label: '<span class=\"required\"><spring:message code=\"UILBL_HR.XXX\" text=\"${COLUMN_DESCRIPTION}\" /></span>', sortable: true, width: 100, align: 'center', editable: true \n}";

	@Override
	public GenerateDatasetAndColumnModelResponseDto generateDatasetAndColumnModel(
			GenerateDatasetAndColumnModelRequestDto requestDto) {
		// Validate input
		validateGenerateData(requestDto);

		// Handle generate
		return handleGenerate(requestDto);
	}

	private void validateGenerateData(GenerateDatasetAndColumnModelRequestDto requestDto) {
		if (requestDto == null || StringUtils.isBlank(requestDto.getBizactorInput()) || requestDto.getCompaPostion() == null) {
			throw new BadRequestException(messageSource.getMessage("data_required", new Object[] {"REQUEST_DTO"},  new Locale(ApiMessageInterceptor.langCode)),
                    "GENERATE DATASET AND COLUMN MODEL", "REQUEST_DTO");
		}
	}

	private GenerateDatasetAndColumnModelResponseDto handleGenerate(GenerateDatasetAndColumnModelRequestDto requestDto) {
		GenerateDatasetAndColumnModelResponseDto responseDto = new GenerateDatasetAndColumnModelResponseDto();
		String[] lines = requestDto.getBizactorInput().split("\\n");
		for (int i = 0; i < lines.length; i++) {
			// Split inline special tab
			String[] inlines = lines[i].split("\\t");
			DatasetDto datasetDto = new DatasetDto(inlines.length > 0 ? inlines[0] : null
					, inlines.length > 1 ? inlines[1] : null
					, inlines.length > 3 ? inlines[3] : null);
			ColumnModelDto columnModelDto = new ColumnModelDto(inlines.length > 0 ? inlines[0] : null
					, inlines.length > 1 ? inlines[1] : null
					, inlines.length > 3 ? inlines[3] : null);
			// Add element in to collection
			responseDto.getDatasets().add(datasetDto);
			responseDto.getColumnModels().add(columnModelDto);
		}
		responseDto.setStringDatasets(buildStringDatasets(responseDto.getDatasets(), requestDto.getCompaPostion()));
		responseDto.setStringColumnModels(buildStringColumnModels(responseDto.getColumnModels(), requestDto.getCompaPostion()));
		return responseDto;
	}

	private String buildStringDatasets(List<DatasetDto> datasets, PositionEnum compaPosition) {
		if (CollectionUtils.isEmpty(datasets)) {
			return null;
		}
		StringBuilder stringBuilder = new StringBuilder();
		String tempString = null;
		for (int i = 0; i < datasets.size(); i ++) {
			if (i > 0 && compaPosition == PositionEnum.LEFT) setCompa(compaPosition, stringBuilder, true);
			tempString = FORMAT_STRING_DATASET;
			// Column id
			if (StringUtils.isNotBlank(datasets.get(i).getColumnName())) tempString = tempString.replace("${COLUMN_ID}", datasets.get(i).getColumnName());

			// Column type
			if (StringUtils.isNotBlank(datasets.get(i).getColumnType())) {
				if ("Decimal".equalsIgnoreCase(datasets.get(i).getColumnType())
						|| "Double".equalsIgnoreCase(datasets.get(i).getColumnType())
						|| "Decimal".equalsIgnoreCase(datasets.get(i).getColumnType())
						|| "Int16".equalsIgnoreCase(datasets.get(i).getColumnType())
						|| "Int32".equalsIgnoreCase(datasets.get(i).getColumnType())
						|| "Int64".equalsIgnoreCase(datasets.get(i).getColumnType())) {
					tempString = tempString.replace("${COLUMN_TYPE}", "number");
				} else if ("String".equalsIgnoreCase(datasets.get(i).getColumnType())) {
					tempString = tempString.replace(", type: '${COLUMN_TYPE}'", "");
				}
			}
			stringBuilder = stringBuilder.append(tempString);
			if (i <  datasets.size() - 1 && compaPosition == PositionEnum.RIGHT) setCompa(compaPosition, stringBuilder, true);
			// Column description
			if (StringUtils.isNotBlank(datasets.get(i).getColumnDescription())) {
				stringBuilder = stringBuilder.append(" // " + datasets.get(i).getColumnDescription());
			}
			if (compaPosition == PositionEnum.RIGHT) {
				stringBuilder = stringBuilder.append("\n");
			}
		}
		return stringBuilder.toString();
	}

	private String buildStringColumnModels(List<ColumnModelDto> columnModels, PositionEnum compaPosition) {
		if (CollectionUtils.isEmpty(columnModels)) {
			return null;
		}
		StringBuilder stringBuilder = new StringBuilder();
		String tempString = null;
		for (int i = 0; i < columnModels.size(); i ++) {
			if (i > 0 && compaPosition == PositionEnum.LEFT) setCompa(compaPosition, stringBuilder, false);
			tempString = FORMAT_STRING_COLUMN_MODEL;
			if (StringUtils.isNotBlank(columnModels.get(i).getColumnName())) tempString = tempString.replace("${COLUMN_ID}", columnModels.get(i).getColumnName());
			if (StringUtils.isNotBlank(columnModels.get(i).getColumnType())) tempString = tempString.replace("${COLUMN_TYPE}", columnModels.get(i).getColumnType());
			if (StringUtils.isNotBlank(columnModels.get(i).getColumnDescription())) {
				tempString = tempString.replace("${COLUMN_DESCRIPTION}", columnModels.get(i).getColumnDescription());
			} else {
				tempString = tempString.replace("${COLUMN_DESCRIPTION}", "");
			}
			
			stringBuilder = stringBuilder.append(tempString);
			if (i <  columnModels.size() - 1 && compaPosition == PositionEnum.RIGHT) setCompa(compaPosition, stringBuilder, false);
		}
		return stringBuilder.toString();
	}

	private StringBuilder setCompa(PositionEnum compaPosition, StringBuilder stringBuilder, boolean isDataSet) {
		if (compaPosition == PositionEnum.RIGHT) {
			stringBuilder = isDataSet ? stringBuilder.append(",") : stringBuilder.append(",\n");
		} else if (compaPosition == PositionEnum.LEFT){
			stringBuilder = stringBuilder.append("\n,");
		}
		return stringBuilder;
	}

}
