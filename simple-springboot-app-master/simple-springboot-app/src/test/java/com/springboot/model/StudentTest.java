package com.springboot.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StudentTest {

    @Test
    void testStudentRecord() {
        Student student = new Student("1", "John", "Doe", "20");

        assertEquals("1", student.id());
        assertEquals("John", student.firstName());
        assertEquals("Doe", student.lastName());
        assertEquals("20", student.age());
    }
}