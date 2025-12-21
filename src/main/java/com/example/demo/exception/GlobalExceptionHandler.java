package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

// Custom exceptions
class DuplicateEmailException extends RuntimeException {
    public DuplicateEmailException(String message) { super(message); }
}

class DuplicateSerialNumberException extends RuntimeException {
    public DuplicateSerialNumberException(String message) { super(message); }
}

class InvalidExpiryDateException extends RuntimeException {
    public InvalidExpiryDateException(String message) { super(message); }
}

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handles validation errors from annotations (@NotBlank, @Size, etc.)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // Duplicate user email
    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<String> handleDuplicateEmail(DuplicateEmailException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Duplicate serial number
    @ExceptionHandler(DuplicateSerialNumberException.class)
    public ResponseEntity<String> handleDuplicateSerialNumber(DuplicateSerialNumberException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Invalid expiry date
    @ExceptionHandler(InvalidExpiryDateException.class)
    public ResponseEntity<String> handleInvalidExpiryDate(InvalidExpiryDateException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Fallback for other runtime exceptions
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
