package com.bobi.ProductsService.exception;

import com.bobi.ProductsService.exception.exc.ProductNotConfigurable;
import com.bobi.ProductsService.exception.exc.ProductNotFound;
import com.bobi.ProductsService.exception.exc.ProductNullFieldsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EntityRestExceptionHandler {

    @ExceptionHandler(ProductNullFieldsException.class)
    public ResponseEntity<ErrorResponse> handleException(ProductNullFieldsException exc) {

        ErrorResponse error = errorResponseGenerator(
                exc.getMessage(),
                HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<ErrorResponse> handleException(ProductNotFound exc) {

        ErrorResponse error = errorResponseGenerator(
                exc.getMessage(),
                HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotConfigurable.class)
    public ResponseEntity<ErrorResponse> handleException(ProductNotConfigurable exc) {

        ErrorResponse error = errorResponseGenerator(
                exc.getMessage(),
                HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    private ErrorResponse errorResponseGenerator(String message, HttpStatus httpStatus) {
        ErrorResponse error = new ErrorResponse();

        error.setStatus(httpStatus.value());
        error.setMessage(message);
        error.setTimestamp(System.currentTimeMillis());

        return error;
    }
}
