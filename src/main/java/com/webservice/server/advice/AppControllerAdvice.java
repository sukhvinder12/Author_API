package com.webservice.server.advice;

import com.webservice.server.Exceptions.ErrorMessage;
import com.webservice.server.Exceptions.NoRecordsException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
@Component
public class AppControllerAdvice {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handlerConstraintViolationExceptions(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        return new ResponseEntity<>(new ErrorMessage(constraintViolations.stream().
                map(constraintViolation -> constraintViolation.getMessage())
                .collect(Collectors.toList()).get(0)), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoRecordsException.class)
    public ResponseEntity<?> handleNoRecordsException(NoRecordsException ex) {
        return new ResponseEntity<>(new ErrorMessage(ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}
