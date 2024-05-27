package com.baont8.toolgenerate.entity.toolGenerate;

import java.io.Serializable;
import java.time.Instant;

import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.baont8.toolgenerate.enumration.StatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@Audited
@EntityListeners(AuditingEntityListener.class)
public class AbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@CreatedDate
	@JsonIgnore
	@Column(name = "CRT_DT", updatable = false)
	private Instant crtDt = Instant.now();

	@LastModifiedDate
	@JsonIgnore
	@Column(name = "UPDT_DT")
	private Instant updtDt = Instant.now();

	@Column(name = "STATUS", nullable = false, columnDefinition = "varchar(255) default 'USING'")
	@Enumerated(EnumType.STRING)
	private StatusEnum status = StatusEnum.USING;

	public Instant getCrtDt() {
		return crtDt;
	}

	public void setCrtDt(Instant crtDt) {
		this.crtDt = crtDt;
	}

	public Instant getUpdtDt() {
		return updtDt;
	}

	public void setUpdtDt(Instant updtDt) {
		this.updtDt = updtDt;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

}
