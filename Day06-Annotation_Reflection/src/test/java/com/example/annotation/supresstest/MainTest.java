package com.example.annotation.supresstest;

import com.example.annotation.supress.UncheckedWarningExample;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class MainTest {

    @Test
    void testAddElements() {
        UncheckedWarningExample example = new UncheckedWarningExample();
        assertDoesNotThrow(example::addElements);
    }
}
