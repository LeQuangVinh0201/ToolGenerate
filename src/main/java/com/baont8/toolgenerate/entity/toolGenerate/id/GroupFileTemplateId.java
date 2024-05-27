package com.baont8.toolgenerate.entity.toolGenerate.id;

import java.io.Serializable;

public class GroupFileTemplateId implements Serializable {

	private static final long serialVersionUID = 1L;

	private int groupData;

	private int fileTemplate;

	public int getGroupData() {
		return groupData;
	}

	public void setGroupData(int groupData) {
		this.groupData = groupData;
	}

	public int getFileTemplate() {
		return fileTemplate;
	}

	public void setFileTemplate(int fileTemplate) {
		this.fileTemplate = fileTemplate;
	}

}
