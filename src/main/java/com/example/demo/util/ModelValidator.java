package com.example.demo.util;

/**
 * Utility class for common model validations.
 * Currently not used directly in services, but included
 * to satisfy project structure and future extensibility.
 */
public class ModelValidator {

    private ModelValidator() {
        // prevent instantiation
    }

    public static boolean isNullOrBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static void require(boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }
}
