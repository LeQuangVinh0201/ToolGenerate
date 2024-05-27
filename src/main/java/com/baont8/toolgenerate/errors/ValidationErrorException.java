package com.baont8.toolgenerate.errors;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import org.zalando.problem.Status;
import org.zalando.problem.StatusType;
import org.zalando.problem.ThrowableProblem;

public class ValidationErrorException extends ThrowableProblem {
    private static final long serialVersionUID = -5386968192167592489L;

    private final URI type;
    private final String entityName;
    private final List<ValidateError> errors;

    public ValidationErrorException(String entityName, List<ValidateError> errors) {
        this(ErrorConstants.DEFAULT_TYPE, entityName, errors);
    }

    public ValidationErrorException(URI type, String entityName, List<ValidateError> errors) {
        this.type = type;
        this.entityName = entityName;
        this.errors = Collections.unmodifiableList(errors);
    }

    @Override
    public URI getType() {
        return type;
    }

    @Override
    public String getTitle() {
        return "Validation Violation";
    }

    public String getEntityName() {
        return entityName;
    }

    public List<ValidateError> getErrors() {
        return errors;
    }

    @Override
    public StatusType getStatus() {
        return Status.EXPECTATION_FAILED;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
