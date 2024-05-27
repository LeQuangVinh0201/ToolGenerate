package com.baont8.toolgenerate.errors;

public class UploadFileException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String entityName;

    private String fieldName;

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public UploadFileException(String message, String entityName, String fieldName) {
        super(message);
        this.entityName = entityName;
        this.fieldName = fieldName;
    }

    public UploadFileException(String message, String entityName) {
        super(message);
        this.entityName = entityName;
    }
}
