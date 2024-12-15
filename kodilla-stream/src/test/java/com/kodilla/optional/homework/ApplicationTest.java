package com.kodilla.optional.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {

    @Test
    public void testGenerateStudentDescription() {
        Student withTeacher = new Student("Anya Scott", new Teacher("Mckenzie Bush"));
        Student withoutTeacher = new Student("Humaira Barry", null);

        assertEquals(
            "student: Anya Scott - teacher: Mckenzie Bush",
            Application.generateStudentDescription(withTeacher)
        );

        assertEquals(
            "student: Humaira Barry - teacher: <undefined>",
            Application.generateStudentDescription(withoutTeacher)
        );
    }
}
