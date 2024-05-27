package com.baont8.toolgenerate.enumration;

public enum YesNoEnum {

	YES("YES", true),
	NO("NO", false);
	
	private YesNoEnum(String text, boolean value) {
		this.text = text;
		this.value = value;
	}

	private String text;
	private boolean value;

	public String getText() {
		return text;
	}

	public boolean isValue() {
		return value;
	}

}
