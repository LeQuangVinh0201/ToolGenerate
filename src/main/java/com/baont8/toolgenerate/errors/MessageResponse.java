package com.baont8.toolgenerate.errors;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageResponse {

    @JsonProperty("entity_name")
    private String entityName;

    @JsonProperty("message")
    private String message;

    @JsonProperty("timestamp")
    private Instant timestamp = Instant.now();

    @JsonProperty("status")
    private int status;

    @JsonProperty("field_name")
    private String fieldName;

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

}
