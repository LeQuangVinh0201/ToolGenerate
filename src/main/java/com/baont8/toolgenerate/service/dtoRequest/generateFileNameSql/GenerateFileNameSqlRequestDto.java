package com.baont8.toolgenerate.service.dtoRequest.generateFileNameSql;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenerateFileNameSqlRequestDto {

	@JsonProperty(value = "BRANCH_NAME_NEXTHR_CORE")
	private String branchName;

	@JsonProperty(value = "VERSION_YEAR_NEXTHR_CORE")
	private String versionYear;

	@JsonProperty(value = "VERSION_NEXTHR_CORE")
	private String version;

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getVersionYear() {
		return versionYear;
	}

	public void setVersionYear(String versionYear) {
		this.versionYear = versionYear;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
