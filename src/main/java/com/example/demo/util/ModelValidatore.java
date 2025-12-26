package com.example.demo.util;

public class ModelValidatore {

    // Correct constructor (same name as class)
    public ModelValidatore() {
    }

    // Generic null check
    public static boolean isValid(Object obj) {
        return obj != null;
    }

    // String validation
    public static boolean isValidString(String value) {
        return value != null && !value.trim().isEmpty();
    }

    // ID validation
    public static boolean isValidId(Long id) {
        return id != null && id > 0;
    }
}
