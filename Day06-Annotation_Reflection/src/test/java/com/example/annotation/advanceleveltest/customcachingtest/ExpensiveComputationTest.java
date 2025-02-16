package com.example.annotation.advanceleveltest.customcachingtest;

import com.example.annotation.advancelevel.customcaching.ExpensiveComputation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExpensiveComputationTest {

    @Test
    void testCachingMechanism() {
        ExpensiveComputation obj = new ExpensiveComputation();

        int firstCall = obj.computeSquare(6);
        int secondCall = obj.computeSquare(6);

        assertEquals(36, firstCall);
        assertEquals(36, secondCall);
    }

    @Test
    void testDifferentValues() {
        ExpensiveComputation obj = new ExpensiveComputation();

        assertEquals(49, obj.computeSquare(7));
        assertEquals(64, obj.computeSquare(8));
    }
}
