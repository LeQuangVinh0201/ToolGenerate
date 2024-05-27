package com.baont8.toolgenerate.enumration;

public enum SettingEnum {

	FILE_TEMPLATE_TO_CREATE_CM_MESSAGE_FOR_NEXTHR_CORE("File template to create cm message for nexthr-core project"),
	FILE_TEMPLATE_TO_CREATE_CM_MESSAGE_FOR_HR_CORE("File template to create cm message for hr-core project");
	
	SettingEnum(String text) {
		this.text = text;
	}

	private String text;

	public String getText() {
		return text;
	}

}
