package com.example.demo.exception;

public class InvalidExpiryDateException extends RuntimeException {
    public InvalidExpiryDateException(String message) {
        super(message);
    }
}
