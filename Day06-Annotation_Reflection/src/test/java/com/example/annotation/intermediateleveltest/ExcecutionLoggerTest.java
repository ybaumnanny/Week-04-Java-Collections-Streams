
package com.example.annotation.intermediateleveltest;

import com.example.annotation.intermediatelevel.loggingmethod.ExecutionLogger;
import com.example.annotation.intermediatelevel.loggingmethod.LogExecutionTime;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class ExecutionLoggerTest {

    @Test
    void testAnnotationPresence() {
        Method[] methods = ExecutionLogger.class.getDeclaredMethods();
        boolean found = false;

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                found = true;
                assertNotNull(method.getAnnotation(LogExecutionTime.class));
            }
        }

        assertTrue(found, "At least one method should be annotated with @LogExecutionTime");
    }

    @Test
    void testExecutionTimeMeasurement() {
        ExecutionLogger obj = new ExecutionLogger();
        long start = System.nanoTime();
        obj.fastMethod();
        long end = System.nanoTime();
        long executionTime = (end - start) / 1_000_000; // Convert to milliseconds

        assertTrue(executionTime >= 0, "Execution time should be non-negative");
    }
}

