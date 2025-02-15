package calculatortest;
import com.calculatorclass.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
     Calculator calculator = new Calculator();
    @Test
    void testAdd() {

        assertEquals(5, calculator.add(2, 3));
    }
    @Test
    void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
    }
    @Test
    void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
    }
    @Test
    void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
    }
    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(6, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}


