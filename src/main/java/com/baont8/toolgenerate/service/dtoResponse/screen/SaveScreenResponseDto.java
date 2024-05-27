package com.baont8.toolgenerate.service.dtoResponse.screen;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SaveScreenResponseDto {

	@JsonProperty(value = "SCREEN_ID")
	private int screenId;

	@JsonProperty(value = "MENU_NAME")
	private String menuName;
	
	@JsonProperty(value = "MENU_CODE")
	private String menuCode;
	
	@JsonProperty(value = "CREATOR")
	private String creator;
	
	@JsonProperty(value = "COMMENT")
	private String comment;

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
