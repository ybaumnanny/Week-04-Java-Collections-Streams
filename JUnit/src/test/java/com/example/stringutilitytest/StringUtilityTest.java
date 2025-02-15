package stringutilitytest;
import com.stringutilityclass.StringUtility;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilityTest {
    StringUtility stringUtils = new StringUtility();
    @Test
    void testReverse() {
        assertEquals("dcba", stringUtils.reverse("abcd"));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(stringUtils.isPalindrome("madam"));
        assertFalse(stringUtils.isPalindrome("hello"));
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", stringUtils.toUpperCase("hello"));
    }
}