package com.baont8.toolgenerate.enumration;

public enum ParameterTypeEnum {

	PARAM("PARAMETER WANT TO CHANGE"),
	BLOCK("BLOCK PARAMETER TO USE OR NON-USE");
	
	ParameterTypeEnum(String text) {
		this.text = text;
	}

	private String text;

	public String getText() {
		return text;
	}
	
}
