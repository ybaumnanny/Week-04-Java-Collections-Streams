package com.example.annotation.advancelevel.serializationannotation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class User {

    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String toJson() {
        Map<String, String> jsonMap = new HashMap<>();

        try {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(JsonField.class)) {
                    field.setAccessible(true);
                    JsonField annotation = field.getAnnotation(JsonField.class);
                    jsonMap.put(annotation.name(), field.get(this).toString());
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
            json.append("\"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\", ");
        }
        if (json.length() > 1) json.setLength(json.length() - 2); // Remove trailing comma
        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) {
        User user = new User("Yaman Mahtha", 22);
        System.out.println("JSON Output: " + user.toJson());
    }
}
