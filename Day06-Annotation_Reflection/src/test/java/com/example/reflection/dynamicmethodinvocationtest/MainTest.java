package com.example.reflection.dynamicmethodinvocationtest;

import com.example.reflection.dynamicmethodinvocation.Main;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testAddition() {
        assertEquals(15, invokeTestMethod("add", 10, 5));
    }

    @Test
    void testSubtraction() {
        assertEquals(5, invokeTestMethod("subtract", 10, 5));
    }

    @Test
    void testMultiplication() {
        assertEquals(50, invokeTestMethod("multiply", 10, 5));
    }

    private int invokeTestMethod(String methodName, int a, int b) {
        try {
            return Main.invokeMethod(methodName,a,b);
        } catch (Exception e) {
            fail("Reflection invocation failed");
            return -1;
        }
    }
}