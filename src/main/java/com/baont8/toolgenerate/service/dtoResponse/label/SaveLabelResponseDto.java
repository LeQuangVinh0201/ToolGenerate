package com.baont8.toolgenerate.service.dtoResponse.label;

import com.baont8.toolgenerate.enumration.StatusEnum;
import com.baont8.toolgenerate.service.dto.label.LabelDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class SaveLabelResponseDto extends LabelDto{

	@JsonIgnore
	private StatusEnum status;

}
