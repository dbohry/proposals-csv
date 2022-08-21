package com.danielbohry.applications.api;

import com.danielbohry.applications.exception.CsvException;
import com.danielbohry.applications.exception.NotFoundException;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {PropertyReferenceException.class})
  protected ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {
    String message = "Please check the request parameters";
    return handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }

  @ExceptionHandler(value = {CsvException.class})
  protected ResponseEntity<Object> handleCsvError(RuntimeException ex, WebRequest request) {
    String message = "Impossible to import data from csv";
    return handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
  }

  @ExceptionHandler(value = {NotFoundException.class})
  protected ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request) {
    String message = "Resource not found";
    return handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
  }

}
