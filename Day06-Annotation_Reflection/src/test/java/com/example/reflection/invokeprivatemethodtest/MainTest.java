package com.example.reflection.invokeprivatemethodtest;

import com.example.reflection.invokeprivatemethod.Calculator;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testMultiplyUsingReflection() {
        try {
            Calculator calculator = new Calculator();
            Method method = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
            method.setAccessible(true);
            int result = (int) method.invoke(calculator, 4, 5);
            assertEquals(20, result);
        } catch (Exception e) {
            fail("Reflection invocation failed");
        }
    }

    @Test
    void testMultiplyWithZero() {
        try {
            Calculator calculator = new Calculator();
            Method method = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
            method.setAccessible(true);
            int result = (int) method.invoke(calculator, 7, 0);
            assertEquals(0, result);
        } catch (Exception e) {
            fail("Reflection invocation failed");
        }
    }
}
