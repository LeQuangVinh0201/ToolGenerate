package com.baont8.toolgenerate.entity.toolGenerate;

import com.baont8.toolgenerate.entity.toolGenerate.id.GroupFileTemplateId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "GROUP_FILE_TEMPLATE")
@IdClass(GroupFileTemplateId.class)
public class GroupFileTemplate extends AbstractAuditingEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "GROUP_ID")
	private GroupData groupData;

	@Id
	@ManyToOne
	@JoinColumn(name = "FILE_TEMPLATE_ID")
	private FileTemplate fileTemplate;

	public GroupData getGroupData() {
		return groupData;
	}

	public void setGroupData(GroupData groupData) {
		this.groupData = groupData;
	}

	public FileTemplate getFileTemplate() {
		return fileTemplate;
	}

	public void setFileTemplate(FileTemplate fileTemplate) {
		this.fileTemplate = fileTemplate;
	}

}
