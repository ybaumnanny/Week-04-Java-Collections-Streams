package com.example.annotation.advanceleveltest;


import com.example.annotation.advancelevel.serializationannotation.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testJsonSerialization() {
        User user = new User("Ram", 30);
        String expectedJson = "{\"user_name\": \"Ram\", \"user_age\": \"30\"}";
        assertEquals(expectedJson, user.toJson());
    }
}
