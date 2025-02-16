package com.example.annotation.beginnerleveltest;

import com.example.annotation.beginnerlevel.TaskManager;
import com.example.annotation.beginnerlevel.Todo;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    @Test
    void testTodoAnnotationPresence() {
        Method[] methods = TaskManager.class.getDeclaredMethods();
        boolean found = false;

        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                found = true;
                Todo annotation = method.getAnnotation(Todo.class);
                assertNotNull(annotation);
                assertNotNull(annotation.task());
                assertNotNull(annotation.assignedTo());
                assertTrue(annotation.priority().equals("HIGH") ||
                        annotation.priority().equals("MEDIUM") ||
                        annotation.priority().equals("LOW"));
            }
        }

        assertTrue(found, "At least one method should be annotated with @Todo");
    }
}
