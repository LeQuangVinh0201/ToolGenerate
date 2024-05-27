package com.baont8.toolgenerate.entity.toolGenerate;

import com.baont8.toolgenerate.enumration.SettingEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "SETTING")
public class Setting extends AbstractAuditingEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODE", nullable = false)
	@Enumerated(EnumType.STRING)
	private SettingEnum code;

	@Column(name = "VALUE", nullable = false)
	@Lob
	private String value;

	public SettingEnum getCode() {
		return code;
	}

	public void setCode(SettingEnum code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Setting(SettingEnum code) {
		super();
		this.code = code;
	}

	public Setting() {
		super();
	}

}
