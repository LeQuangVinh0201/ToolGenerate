package com.baont8.toolgenerate.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends RuntimeException {

    private static final long serialVersionUID = -1L;

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

    public InternalServerErrorException(String message, String entityName, String fieldName) {
        super(message);
        this.entityName = entityName;
        this.fieldName = fieldName;
    }

    public InternalServerErrorException(String message, String entityName) {
        super(message);
        this.entityName = entityName;
    }

}
