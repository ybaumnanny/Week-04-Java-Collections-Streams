package com.example.reflection.accessandmodifystaticfields;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        System.out.println("Before modification: " + Configuration.getApiKey());
        modifyStaticField();
        System.out.println("After modification: " + Configuration.getApiKey());
    }

    public static void modifyStaticField() {
        try {
            Class<?> clazz = Class.forName("com.example.reflection.accessandmodifystaticfields.Configuration");

            Field field = clazz.getDeclaredField("API_KEY");

            field.setAccessible(true);
            field.set(null, "NEW_API_KEY");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
