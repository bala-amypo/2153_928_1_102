package com.example.demo.util;

public class ModelValidatore{

    private ModelValidator() {
        // Utility class – prevent object creation
    }

    // Validate String field
    public static void validateString(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " is required");
        }
    }

    // Validate ID
    public static void validateId(Long id, String fieldName) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException(fieldName + " must be valid");
        }
    }

    // Validate date logic
    public static void validateDateOrder(
            java.time.LocalDate start,
            java.time.LocalDate end,
            String message) {

        if (start == null || end == null || !end.isAfter(start)) {
            throw new IllegalArgumentException(message);
        }
    }
}
