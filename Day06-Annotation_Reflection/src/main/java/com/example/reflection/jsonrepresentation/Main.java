package com.example.reflection.jsonrepresentation;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Yaman Mahtha", 22, "mahthayaman@gmail.com");
        String json = objectToJson(person);
        System.out.println(json);
    }

    public static String objectToJson(Object obj) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");

        try {
            Class<?> cls = obj.getClass();
            Field[] fields = cls.getDeclaredFields();

            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                String fieldName = fields[i].getName();
                Object fieldValue = fields[i].get(obj);

                jsonBuilder.append("\"").append(fieldName).append("\": ");

                if (fieldValue instanceof String) {
                    jsonBuilder.append("\"").append(fieldValue).append("\"");
                } else {
                    jsonBuilder.append(fieldValue);
                }

                if (i < fields.length - 1) {
                    jsonBuilder.append(", ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}
