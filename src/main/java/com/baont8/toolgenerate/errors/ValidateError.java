package com.baont8.toolgenerate.errors;

public class ValidateError {
    private String fieldName;

    private String messageError;

    public ValidateError(String fieldName, String messageError) {
        super();
        this.fieldName = fieldName;
        this.messageError = messageError;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }
}
