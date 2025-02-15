package exceptionhandlingtest;

import static org.junit.jupiter.api.Assertions.*;

import com.exceptionhandlingclass.ExceptionHandling;
import org.junit.jupiter.api.Test;

class ExceptionHandlingTest {
    @Test
    void testDivideByZeroThrowsException() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            ExceptionHandling.divide(10, 0);
        });

        // Match the actual message thrown in Calculator.java
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
