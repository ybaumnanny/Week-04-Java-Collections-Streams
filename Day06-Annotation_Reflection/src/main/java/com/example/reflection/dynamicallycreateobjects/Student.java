package com.example.reflection.dynamicallycreateobjects;

public class Student {
    private String name;
    private int age;

    Student() {
        this.name = "Default Name";
        this.age = 18;
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getDetails() {
        return "Student Name: " + name + ", Age: " + age;
    }
}
