package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class PersonSources {
    static Stream<Arguments> providePersonsForTestingBMI() {
        return Stream.of(
                Arguments.of(new Person(2.00, 58), "Very severely underweight"),
                Arguments.of(new Person(1.55, 37), "Severely underweight"),
                Arguments.of(new Person(1.82, 60), "Underweight"),
                Arguments.of(new Person(1.75, 70), "Normal (healthy weight)"),
                Arguments.of(new Person(1.67, 78), "Overweight"),
                Arguments.of(new Person(1.62, 87), "Obese Class I (Moderately obese)"),
                Arguments.of(new Person(1.91, 142), "Obese Class II (Severely obese)"),
                Arguments.of(new Person(1.78, 130), "Obese Class III (Very severely obese)"),
                Arguments.of(new Person(1.47, 103), "Obese Class IV (Morbidly Obese)"),
                Arguments.of(new Person(1.88, 187), "Obese Class V (Super Obese)"),
                Arguments.of(new Person(1.70, 197), "Obese Class VI (Hyper Obese)")
        );
    }
}
