package com.example.reflection.dynamicallycreateobjectstest;

import com.example.reflection.dynamicallycreateobjects.Main;
import com.example.reflection.dynamicallycreateobjects.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainAppTest {

    @Test
    void testDefaultStudentInstance() {
        Student student = Main.createStudentInstance();
        assertNotNull(student);
        assertEquals("Student Name: Default Name, Age: 18", student.getDetails());
    }

    @Test
    void testParameterizedStudentInstance() {
        Student student = Main.createStudentInstance("Alice", 21);
        assertNotNull(student);
        assertEquals("Student Name: Alice, Age: 21", student.getDetails());
    }
}