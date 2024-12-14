package com.kodilla.optional.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
            new Student("Scout Duke", new Teacher("Martha Nguyen")),
            new Student("Paola Rice", null),
            new Student("Laurel Reilly", new Teacher("Brooklyn Hopkins"))
        ));

        for (Student student : students) {
            System.out.println(
                "student: "
                    + student.getName()
                    + " - teacher: "
                    + Optional.ofNullable(student.getTeacher()).orElse(new Teacher("<undefined>")).getName()
            );
        }
    }
}
