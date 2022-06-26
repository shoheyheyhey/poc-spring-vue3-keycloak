package com.example.backend.shared;

import java.lang.reflect.Field;

public class TestSupport {
    public static Object getPrivateField(Object target, String field) {

        try {
            Class targetClass = target.getClass();
            Field targetField = targetClass.getDeclaredField(field);
            targetField.setAccessible(true);
            return targetField.get(target);
        } catch (Exception e) {
            return null;
        }
    }
}
