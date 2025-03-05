package com.kodilla.collections.adv.maps.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SchoolTest {
    @Test
    void testGetAllStudentsCount() {
        List classes = Arrays.asList(21, 19, 24);
        School school = new School("", classes);
        Assertions.assertEquals(classes.stream().mapToInt(number -> (int) number).sum(), school.getAllStudentsCount());

        List emptyClasses = Arrays.asList(0, 0, 0);
        School emptyClassesSchool = new School("", emptyClasses);
        Assertions.assertEquals(0, emptyClassesSchool.getAllStudentsCount());

        School emptySchool = new School("", Arrays.asList());
        Assertions.assertEquals(0, emptySchool.getAllStudentsCount());
    }
}
