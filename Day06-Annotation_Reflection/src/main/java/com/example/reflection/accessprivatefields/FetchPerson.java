package com.example.reflection.accessprivatefields;

import java.lang.reflect.Field;

public class FetchPerson {
    public static void modifyAge(Person person, int newAge) {
        try {
            Field ageField = Person.class.getDeclaredField("age");
            ageField.setAccessible(true);
            ageField.set(person, newAge);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static int retrieveAge(Person person) {
        try {
            Field ageField = Person.class.getDeclaredField("age");
            ageField.setAccessible(true);
            return (int) ageField.get(person);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) {
        Person person = new Person(25);
        System.out.println("Original Age: " + retrieveAge(person));

        modifyAge(person, 30);
        System.out.println("Modified Age: " + retrieveAge(person));
    }
}