package com.baont8.toolgenerate.enumration;

public enum StatusEnum {

	USING("USING IN PROJECT"),
	DELETE("DELETED IN PROJECT");
	
	StatusEnum(String text) {
		this.text = text;
	}

	private String text;

	public String getText() {
		return text;
	}
	
}
