package com.baont8.toolgenerate.service.dtoRequest.fileTemplate;

import org.springframework.data.domain.Pageable;

import com.baont8.toolgenerate.enumration.StatusEnum;

public class GetListFileTemplateRequestDto {

	private Pageable pageable;

	private Integer sizeCheckShowAll;

	private StatusEnum status;

	public Pageable getPageable() {
		return pageable;
	}

	public void setPageable(Pageable pageable) {
		this.pageable = pageable;
	}

	public Integer getSizeCheckShowAll() {
		return sizeCheckShowAll;
	}

	public void setSizeCheckShowAll(Integer sizeCheckShowAll) {
		this.sizeCheckShowAll = sizeCheckShowAll;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

}
