package com.example.reflection.jsonrepresentationtest;

import com.example.reflection.jsonrepresentation.Main;
import com.example.reflection.jsonrepresentation.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testObjectToJson() {
        Person person = new Person("Bob", 30, "bob@example.com");
        String expectedJson = "{\"name\": \"Bob\", \"age\": 30, \"email\": \"bob@example.com\"}";
        assertEquals(expectedJson, Main.objectToJson(person));
    }

    @Test
    void testEmptyObject() {
        Person person = new Person("", 0, "");
        String expectedJson = "{\"name\": \"\", \"age\": 0, \"email\": \"\"}";
        assertEquals(expectedJson, Main.objectToJson(person));
    }
}

