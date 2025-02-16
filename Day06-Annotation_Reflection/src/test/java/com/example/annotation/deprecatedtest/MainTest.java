package com.example.annotation.deprecatedtest;

import com.example.annotation.deprecated.LegacyAPI;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testNewFeature() {
        LegacyAPI api = new LegacyAPI();
        assertEquals("This is the new and improved feature.", getMethodOutput(api::newFeature));
    }

    @SuppressWarnings("deprecation")
    @Test
    void testOldFeature() {
        LegacyAPI api = new LegacyAPI();
        assertEquals("This is an old feature and should not be used.", getMethodOutput(api::oldFeature));
    }

    private String getMethodOutput(Runnable methodCall) {
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        methodCall.run();
        System.setOut(System.out);
        return out.toString().trim();
    }
}
