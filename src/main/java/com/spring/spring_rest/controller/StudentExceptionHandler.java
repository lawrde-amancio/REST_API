package com.spring.spring_rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import com.spring.spring_rest.entity.StudentErrorResponse;
import com.spring.spring_rest.exception.StudentNotFoundException;

/**
 * Global exception handler for REST controllers across the application.
 * <p>
 * Intercepts exceptions thrown during HTTP request processing and translates
 * them into structured HTTP error responses with appropriate status codes.
 * </p>
 */
@ControllerAdvice 
public class StudentExceptionHandler {

    /**
     * Handles {@link StudentNotFoundException} when a requested student resource does not exist.
     *
     * @param ex the thrown {@link StudentNotFoundException}
     * @return a {@link ResponseEntity} containing a {@link StudentErrorResponse} with HTTP status {@code 404 Not Found}
     */
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException (
        StudentNotFoundException ex) {
        
        StudentErrorResponse err = new StudentErrorResponse();
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(ex.getMessage());
        err.setTimeStamp(System.currentTimeMillis());
        
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles general unhandled exceptions, such as type mismatch errors on path variables.
     *
     * @param ex the thrown {@link Exception}
     * @return a {@link ResponseEntity} containing a {@link StudentErrorResponse} with HTTP status {@code 400 Bad Request}
     */
    @ExceptionHandler 
    public ResponseEntity<StudentErrorResponse> handleException(
        Exception ex) {
            StudentErrorResponse err = new StudentErrorResponse();
            err.setStatus(HttpStatus.BAD_REQUEST.value());
            err.setMessage("Invalid data. Only Integers are accepted");
            err.setTimeStamp(System.currentTimeMillis());

            return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
        }
    
        /**
     * Handles bean validation failures triggered by {@code @Valid} request bodies.
     *
     * @param ex the thrown {@link MethodArgumentNotValidException} 
     * containing field validation errors
     * @return a {@link ResponseEntity} 
     * containing a map of field names to validation error messages
     *         with HTTP status {@code 400 Bad Request}
     */
    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(
        MethodArgumentNotValidException ex) {
            Map<String, String> err = new HashMap<>();

            //extract every field error and its custom message
            ex.getBindingResult().getFieldErrors().forEach(error -> {
                err.put(error.getField(), error.getDefaultMessage());
            });
            return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
        }
}
