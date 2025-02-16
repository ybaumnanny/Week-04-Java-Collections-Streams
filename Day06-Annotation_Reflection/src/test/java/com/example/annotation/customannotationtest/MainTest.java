
package com.example.annotation.customannotationtest;

import com.example.annotation.customannotation.TaskInfo;
import com.example.annotation.customannotation.TaskManager;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testTaskInfoAnnotation() throws NoSuchMethodException {
        Method method = TaskManager.class.getDeclaredMethod("criticalTask");
        TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

        assertNotNull(taskInfo);
        assertEquals("High", taskInfo.priority());
        assertEquals("Ankit kumar", taskInfo.assignedTo());
    }
}

