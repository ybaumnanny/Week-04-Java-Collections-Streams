package com.example.reflection.accessandmodifystaticfieldstest;

import com.example.reflection.accessandmodifystaticfields.Configuration;
import com.example.reflection.accessandmodifystaticfields.Main;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testModifyStaticField() {
        try {
            Main.modifyStaticField();
            assertEquals("NEW_API_KEY", Configuration.getApiKey());

        } catch (Exception e) {
            fail("Reflection failed");
        }
    }
}
