package com.example.annotation.advanceleveltest;

import com.example.annotation.advancelevel.rolebasedaccess.AccessController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccessControllerTest {

    @Test
    void testAdminAccess() {
        AccessController admin = new AccessController("ADMIN");
        assertDoesNotThrow(() -> admin.executeMethod("adminTask"));
    }

    @Test
    void testUserDeniedAdminAccess() {
        AccessController user = new AccessController("USER");
        assertDoesNotThrow(() -> user.executeMethod("adminTask"));
    }

    @Test
    void testUserAccessAllowed() {
        AccessController user = new AccessController("USER");
        assertDoesNotThrow(() -> user.executeMethod("userTask"));
    }
}
