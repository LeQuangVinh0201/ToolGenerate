package com.baont8.toolgenerate.entity.toolGenerate.id;

import java.io.Serializable;

public class RelationshipFileParameterId implements Serializable {

	private static final long serialVersionUID = 1L;

	private int groupId;

	private int fileTemplateParameterId;

	private int relationshipFileTemplateId;

	private int relationshipFileParameterId;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getFileTemplateParameterId() {
		return fileTemplateParameterId;
	}

	public void setFileTemplateParameterId(int fileTemplateParameterId) {
		this.fileTemplateParameterId = fileTemplateParameterId;
	}

	public int getRelationshipFileTemplateId() {
		return relationshipFileTemplateId;
	}

	public void setRelationshipFileTemplateId(int relationshipFileTemplateId) {
		this.relationshipFileTemplateId = relationshipFileTemplateId;
	}

	public int getRelationshipFileParameterId() {
		return relationshipFileParameterId;
	}

	public void setRelationshipFileParameterId(int relationshipFileParameterId) {
		this.relationshipFileParameterId = relationshipFileParameterId;
	}

	
}
