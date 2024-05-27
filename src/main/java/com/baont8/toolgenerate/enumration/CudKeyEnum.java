package com.baont8.toolgenerate.enumration;

public enum CudKeyEnum {

	CREATE("Create"),
	UPDATE("Update"),
	DELETE("Delete");

	private String description;

	private CudKeyEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
