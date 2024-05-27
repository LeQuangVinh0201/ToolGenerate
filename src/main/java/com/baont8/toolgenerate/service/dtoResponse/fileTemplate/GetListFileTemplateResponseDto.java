package com.baont8.toolgenerate.service.dtoResponse.fileTemplate;

import com.baont8.toolgenerate.service.dto.fileTemplate.FileTemplateDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetListFileTemplateResponseDto extends FileTemplateDto {

	@JsonProperty(value = "FORMAT_CRT_DT")
	private String formatCrtDt;

	@JsonProperty(value = "FORMAT_UPDT_DT")
	private String formatUpdtDt;

	public String getFormatCrtDt() {
		return formatCrtDt;
	}

	public void setFormatCrtDt(String formatCrtDt) {
		this.formatCrtDt = formatCrtDt;
	}

	public String getFormatUpdtDt() {
		return formatUpdtDt;
	}

	public void setFormatUpdtDt(String formatUpdtDt) {
		this.formatUpdtDt = formatUpdtDt;
	}

}
