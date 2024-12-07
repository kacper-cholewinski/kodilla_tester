package com.kodilla.collections.adv.maps.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SchoolDirectory {
    public static void main(String[] args) {
        HashMap<Principal, School> schools = new HashMap<>();

        schools.put(
            new Principal("Omar", "Mccoy"),
            new School("Winters Secondary School", Arrays.asList(23, 22, 24))
        );

        schools.put(
            new Principal("Charlotte", "Lawson"),
            new School("Pioneer Technical School", Arrays.asList(28, 31, 27))
        );

        schools.put(
            new Principal("Sulaiman", "Macdonald"),
            new School("Silver Valley Academy", Arrays.asList(17, 14, 16))
        );

        for (HashMap.Entry<Principal, School> school : schools.entrySet()) {
            System.out.println("Principal: " + school.getKey().getFirstName() + " " + school.getKey().getLastName());
            System.out.println("School name: " + school.getValue().getName());
            System.out.println("Number of students: " + school.getValue().getAllStudentsCount());
        }
    }
}
