package com.baont8.toolgenerate.service.dto.documentStorage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentStorageDto {

	@JsonProperty(value = "ID")
    private Long id;

	@JsonProperty(value = "ORIGINAL_NAME")
    private String originalName;

	@JsonProperty(value = "NAME")
    private String name;

	@JsonProperty(value = "EXTENSION")
    private String extension;

	@JsonProperty(value = "PATH")
    private String path;

	@JsonProperty(value = "SIZE")
    private long size;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

}