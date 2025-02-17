package com.example.reflection.getclassinformation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {
    public static void printClassInfo(Class<?> cls) {
        System.out.println("Class Name: " + cls.getName());

        // Printing constructors
        System.out.println("Constructors:");
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            System.out.println(constructor.getName());
        }

        // Printing methods
        System.out.println("Methods:");
        for (Method method : cls.getDeclaredMethods()) {
            System.out.println(method.getName());
        }

        // Printing fields
        System.out.println("Fields:");
        for (Field field : cls.getDeclaredFields()) {
            System.out.println(field.getName());
        }
    }
    public static void main(String[] args) {
        printClassInfo(SampleClass.class);
    }
}


