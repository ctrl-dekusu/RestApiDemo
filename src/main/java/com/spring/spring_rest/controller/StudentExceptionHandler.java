package com.spring.spring_rest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.spring_rest.entity.StudentErrorResponse;
import com.spring.spring_rest.exception.StudentNotFoundException;

/**
 * Global exception handler for handling REST API exceptions across 
 * controllers.
 */
@ControllerAdvice 
public class StudentExceptionHandler {

  /**
   * Handles {@link StudentNotFoundException} when a requested student 
   * cannot be found.
   *
   * @param ex the thrown {@link StudentNotFoundException}
   * @return a {@link ResponseEntity} containing the error details and 
   * HTTP 404 Not Found status
   */
  @ExceptionHandler 
  public ResponseEntity<StudentErrorResponse> handleException(
    StudentNotFoundException ex
  ) {
    StudentErrorResponse err = new StudentErrorResponse();

    err.setTimeStamp(HttpStatus.NOT_FOUND.value());
    err.setMessage(ex.getMessage());
    err.setTimeStamp(System.currentTimeMillis());

    return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
  }

  /**
   * Handles generic {@link Exception} instances thrown during request 
   * processing.
   *
   * @param ex the thrown {@link Exception}
   * @return a {@link ResponseEntity} containing the error details and 
   * HTTP 400 Bad Request status
   */
  @ExceptionHandler 
  public ResponseEntity<StudentErrorResponse> handleException(
    Exception ex
  ) {
    StudentErrorResponse err = new StudentErrorResponse();

    err.setStatus(HttpStatus.BAD_REQUEST.value());
    err.setMessage("Invalid data. Only integers are accepted");
    err.setTimeStamp(System.currentTimeMillis());

    return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
  }

  /**
   * Handles validation errors triggered by {@code @Valid} request bodies.
   *
   * @param ex the thrown {@link MethodArgumentNotValidException}
   * @return a {@link ResponseEntity} containing a map of field names to 
   * validation error messages and HTTP 400 Bad Request status
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationException(
    MethodArgumentNotValidException ex
  ) {
    Map<String, String> err = new HashMap<>();

    // extract every field error and its custom message
    ex.getBindingResult().getFieldErrors().forEach(error -> {
      err.put(error.getField(), error.getDefaultMessage());
    });

    return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
  }
}
