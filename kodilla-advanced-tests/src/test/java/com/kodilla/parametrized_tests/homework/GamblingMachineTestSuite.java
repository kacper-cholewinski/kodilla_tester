package com.kodilla.parametrized_tests.homework;

import com.kodilla.parametrized_tests.StringValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class GamblingMachineTestSuite {
    GamblingMachine gamblingMachine = new GamblingMachine();

    @ParameterizedTest
    @CsvFileSource(resources = "/userNumbersThrows.csv", numLinesToSkip = 0)
    @NullAndEmptySource
    public void testHowManyWinsThrows(String numbers_as_string) {
        Set<Integer> numbers;

        if (numbers_as_string == null) {
            numbers = null;
        } else if (numbers_as_string.isEmpty()) {
            numbers = new HashSet<>();
        } else {
            numbers = new ArrayList<>(Arrays.asList(numbers_as_string.split(":")))
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        }

        assertThrows(InvalidNumbersException.class, () -> gamblingMachine.howManyWins(numbers));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/userNumbersDoesNotThrow.csv", numLinesToSkip = 0)
    public void testHowManyWinsDoesNotThrow(String numbers_as_string) throws InvalidNumbersException {
        Set<Integer> numbers = new ArrayList<>(Arrays.asList(numbers_as_string.split(":")))
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        gamblingMachine.howManyWins(numbers);
    }
}
