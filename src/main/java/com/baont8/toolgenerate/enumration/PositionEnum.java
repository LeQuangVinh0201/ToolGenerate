package com.baont8.toolgenerate.enumration;

public enum PositionEnum {

	LEFT("LEFT", "left"),
	CENTER("CENTER", "center"),
	RIGHT("RIGHT", "right");

	private String text;
	private String value;

	private PositionEnum(String text, String value) {
		this.text = text;
		this.value = value;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
