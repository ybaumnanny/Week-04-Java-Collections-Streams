package parametrizedtestest;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.parametrizedtestsclass.ParametrizedTest;
import org.junit.jupiter.api.Test;

public class ParametrizedTestTest {

    @Test
    void testIsEven() {
        // Test even numbers
        assertTrue(ParametrizedTest.isEven(2), "2 should be even");
        assertTrue(ParametrizedTest.isEven(4), "4 should be even");
        assertTrue(ParametrizedTest.isEven(6), "6 should be even");

        // Test odd numbers
        assertFalse(ParametrizedTest.isEven(7), "7 should be odd");
        assertFalse(ParametrizedTest.isEven(9), "9 should be odd");
    }
}
