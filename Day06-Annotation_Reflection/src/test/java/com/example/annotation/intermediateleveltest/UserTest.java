
package com.example.annotation.intermediateleveltest;

import com.example.annotation.intermediatelevel.maxlengthannotation.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testValidUsername() {
        assertDoesNotThrow(() -> new User("JohnDoe"));
    }

    @Test
    void testInvalidUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new User("ThisUsernameIsTooLong"));
        assertEquals("Username exceeds max length of 10 characters.", exception.getMessage());
    }
}

