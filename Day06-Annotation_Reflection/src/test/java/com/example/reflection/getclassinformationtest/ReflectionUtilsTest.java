package com.example.reflection.getclassinformationtest;

import com.example.reflection.getclassinformation.ReflectionUtils;
import com.example.reflection.getclassinformation.SampleClass;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionUtilsTest {

    @Test
    void testPrintClassInfo() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Call the method
        ReflectionUtils.printClassInfo(SampleClass.class);

        // Restore the original System.out
        System.setOut(originalOut);

        // Convert output stream to string
        String output = outputStream.toString();

        // Assertions to check if output contains expected details
        assertTrue(output.contains("Class Name: com.example.reflection.getclassinformation.SampleClass"));
        assertTrue(output.contains("Constructors:"));
        assertTrue(output.contains("Methods:"));
        assertTrue(output.contains("Fields:"));
        assertTrue(output.contains("display"));
        assertTrue(output.contains("id"));
        assertTrue(output.contains("name"));
    }
}