package com.example.annotation.repeatableannotationtest;

import com.example.annotation.repeatableannotation.BugReports;
import com.example.annotation.repeatableannotation.SoftwareComponent;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testBugReportAnnotation() throws NoSuchMethodException {
        Method method = SoftwareComponent.class.getDeclaredMethod("processData");
        BugReports bugReports = method.getAnnotation(BugReports.class);

        assertNotNull(bugReports);
        assertEquals(2, bugReports.value().length);
        assertEquals("Null pointer exception in processData", bugReports.value()[0].description());
        assertEquals("Yaman", bugReports.value()[0].reportedBy());
        assertEquals("Performance issue in data processing", bugReports.value()[1].description());
        assertEquals("Shasha", bugReports.value()[1].reportedBy());
    }
}
