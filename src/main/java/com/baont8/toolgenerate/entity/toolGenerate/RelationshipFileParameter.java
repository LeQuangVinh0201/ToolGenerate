package com.baont8.toolgenerate.entity.toolGenerate;

import com.baont8.toolgenerate.entity.toolGenerate.id.RelationshipFileParameterId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "RELATIONSHIP_FILE_PARAMETER")
@IdClass(RelationshipFileParameterId.class)
public class RelationshipFileParameter extends AbstractAuditingEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "GROUP_ID")
	private int groupId;

	@Id
	@Column(name = "FILE_TEMPLATE_PARAMETER_ID")
	private int fileTemplateParameterId;

	@Id
	@Column(name = "RELATIONSHIP_FILE_TEMPLATE_ID")
	private int relationshipFileTemplateId;

	@Id
	@Column(name = "RELATIONSHIP_FILE_PARAMETER_ID")
	private int relationshipFileParameterId;
	
	@Column(name = "PATTERN_VALUE")
	private String patternValue;

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

	public String getPatternValue() {
		return patternValue;
	}

	public void setPatternValue(String patternValue) {
		this.patternValue = patternValue;
	}

}
