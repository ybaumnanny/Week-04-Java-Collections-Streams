package com.example.reflection.dynamicallycreateobjects;

import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args) {
        Student student1 = createStudentInstance();
        Student student2 = createStudentInstance("Ankit kumar", 22);

        System.out.println(student1.getDetails());
        System.out.println(student2.getDetails());
    }

    public static Student createStudentInstance() {
        try {
            Class<?> clazz = Class.forName("com.example.reflection.dynamicallycreateobjects.Student");
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            return (Student) constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Student createStudentInstance(String name, int age) {
        try {
            Class<?> clazz = Class.forName("com.example.reflection.dynamicallycreateobjects.Student");
            Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class);
            return (Student) constructor.newInstance(name, age);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}