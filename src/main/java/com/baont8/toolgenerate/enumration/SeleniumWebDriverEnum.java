package com.baont8.toolgenerate.enumration;

public enum SeleniumWebDriverEnum {

	CHROME("Chrome"),
	FIREFOX("Firefox"),
	EDGE("Edge");

	private String description;

	private SeleniumWebDriverEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
