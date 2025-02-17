package com.example.reflection.retrieveannotationsatruntimetest;

import com.example.reflection.retrieveannotationsatruntime.Author;
import org.junit.jupiter.api.Test;
import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testAuthorAnnotationExists() {
        try {
            Class<?> cls = Class.forName("com.example.reflection.retrieveannotationsatruntime.Book");

            assertTrue(cls.isAnnotationPresent(Author.class));

            Annotation annotation = cls.getAnnotation(Author.class);
            Author author = (Author) annotation;
            assertEquals("Yaman Mahtha", author.name());
        } catch (Exception e) {
            fail("Reflection failed");
        }
    }

    @Test
    void testAuthorAnnotationNotPresentOnOtherClass() {
        try {
            Class<?> cls = Class.forName("java.lang.String");
            assertFalse(cls.isAnnotationPresent(Author.class));
        } catch (Exception e) {
            fail("Reflection failed");
        }
    }
}
