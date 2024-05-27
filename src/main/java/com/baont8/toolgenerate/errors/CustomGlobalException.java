package com.baont8.toolgenerate.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalException extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ NotFoundException.class })
    public ResponseEntity<MessageResponse> handlerNotFound(NotFoundException ex, WebRequest request) {

        MessageResponse customError = new MessageResponse();
        customError.setMessage(ex.getMessage());
        customError.setStatus(HttpStatus.NOT_FOUND.value());
        customError.setEntityName(ex.getEntityName());
        customError.setFieldName(ex.getFieldName());

        return new ResponseEntity<>(customError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ BadRequestException.class })
    public ResponseEntity<MessageResponse> handlerBadRequestException(BadRequestException ex, WebRequest request) {

        MessageResponse customError = new MessageResponse();
        customError.setMessage(ex.getMessage());
        customError.setStatus(HttpStatus.BAD_REQUEST.value());
        customError.setEntityName(ex.getEntityName());
        customError.setFieldName(ex.getFieldName());

        return new ResponseEntity<>(customError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ ForbiddenException.class })
    public ResponseEntity<MessageResponse> handlerForbiddenException(ForbiddenException ex, WebRequest request) {

        MessageResponse customError = new MessageResponse();
        customError.setMessage(ex.getMessage());
        customError.setStatus(HttpStatus.FORBIDDEN.value());
        customError.setEntityName(ex.getEntityName());
        customError.setFieldName(ex.getFieldName());
        
        return new ResponseEntity<>(customError, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({ HttpUnauthorizedException.class })
    public ResponseEntity<MessageResponse> handlerHttpUnauthorizedException(HttpUnauthorizedException ex,
            WebRequest request) {

        MessageResponse customError = new MessageResponse();
        customError.setMessage(ex.getMessage());
        customError.setStatus(HttpStatus.UNAUTHORIZED.value());
        customError.setEntityName(ex.getEntityName());
        customError.setFieldName(ex.getFieldName());
        
        return new ResponseEntity<>(customError, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({ InternalServerErrorException.class })
    public ResponseEntity<MessageResponse> handlerHttpUnauthorizedException(InternalServerErrorException ex,
            WebRequest request) {

        MessageResponse customError = new MessageResponse();
        customError.setMessage(ex.getMessage());
        customError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        customError.setEntityName(ex.getEntityName());
        customError.setFieldName(ex.getFieldName());

        return new ResponseEntity<>(customError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ MaxUploadSizeExceededException.class, UploadFileException.class })
    public ResponseEntity<MessageResponse> handlerUploadFileException(WebRequest request) {

        MessageResponse customError = new MessageResponse();
        customError.setMessage("Maximum size of upload file!");
        customError.setStatus(HttpStatus.BAD_REQUEST.value());
        customError.setEntityName("DOCUMENT STORAGE ENTITY");
        
        return new ResponseEntity<>(customError, HttpStatus.BAD_REQUEST);
    }
}
