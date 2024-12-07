package com.kodilla.collections.adv.maps.homework;

import java.util.List;

public class School {
    String name;
    List<Integer> classes;

    public School(String name, List<Integer> students) {
        this.name = name;
        this.classes = students;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getStudents() {
        return classes;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", students=" + classes +
                '}';
    }

    public int getAllStudentsCount() {
        int studentsCount = 0;

        for (int students : classes) {
            studentsCount += students;
        }

        return studentsCount;
    }
}
