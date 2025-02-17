package com.example.reflection.retrieveannotationsatruntime;

import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) {
        retrieveAnnotation();
    }

    public static void retrieveAnnotation() {
        try {
            Class<?> cls = Class.forName("com.example.reflection.retrieveannotationsatruntime.Book");

            if (cls.isAnnotationPresent(Author.class)) {
                Annotation annotation = cls.getAnnotation(Author.class);
                Author author = (Author) annotation;
                System.out.println("Author of the class: " + author.name());
            } else {
                System.out.println("Author annotation not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
