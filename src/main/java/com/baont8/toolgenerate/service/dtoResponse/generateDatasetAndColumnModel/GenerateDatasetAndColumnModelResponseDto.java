package com.baont8.toolgenerate.service.dtoResponse.generateDatasetAndColumnModel;

import java.util.ArrayList;
import java.util.List;

import com.baont8.toolgenerate.service.dto.generateDatasetAndColumnModel.ColumnModelDto;
import com.baont8.toolgenerate.service.dto.generateDatasetAndColumnModel.DatasetDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GenerateDatasetAndColumnModelResponseDto {

	@JsonProperty(value = "DATASETS")
	private List<DatasetDto> datasets = new ArrayList<>();

	@JsonProperty(value = "STRING_DATASETS")
	private String stringDatasets;

	@JsonProperty(value = "COLUMN_MODELS")
	private List<ColumnModelDto> columnModels = new ArrayList<>();

	@JsonProperty(value = "STRING_COLUMN_MODELS")
	private String stringColumnModels;

	public List<DatasetDto> getDatasets() {
		return datasets;
	}

	public void setDatasets(List<DatasetDto> datasets) {
		this.datasets = datasets;
	}

	public List<ColumnModelDto> getColumnModels() {
		return columnModels;
	}

	public void setColumnModels(List<ColumnModelDto> columnModels) {
		this.columnModels = columnModels;
	}

	public String getStringDatasets() {
		return stringDatasets;
	}

	public void setStringDatasets(String stringDatasets) {
		this.stringDatasets = stringDatasets;
	}

	public String getStringColumnModels() {
		return stringColumnModels;
	}

	public void setStringColumnModels(String stringColumnModels) {
		this.stringColumnModels = stringColumnModels;
	}

}
