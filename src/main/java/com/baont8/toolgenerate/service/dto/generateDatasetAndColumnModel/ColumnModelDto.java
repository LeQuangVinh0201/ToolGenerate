package com.baont8.toolgenerate.service.dto.generateDatasetAndColumnModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ColumnModelDto {

	@JsonProperty(value = "COLUMN_NAME")
	private String columnName;

	@JsonProperty(value = "COLUMN_TYPE")
	private String columnType;

	@JsonProperty(value = "COLUMN_DESCRIPTION")
	private String columnDescription;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getColumnDescription() {
		return columnDescription;
	}

	public void setColumnDescription(String columnDescription) {
		this.columnDescription = columnDescription;
	}

	public ColumnModelDto(String columnName, String columnType, String columnDescription) {
		super();
		this.columnName = columnName;
		this.columnType = columnType;
		this.columnDescription = columnDescription;
	}

	public ColumnModelDto() {
		super();
	}

}
