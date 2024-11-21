package com.kodilla.basic_assertion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTestSuite {
    @Test
    public void testSum() {
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 8;
        int sumResult = calculator.sum(a, b);
        assertEquals(13, sumResult);
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 8;
        int sumResult = calculator.subtract(a, b);
        assertEquals(-3, sumResult);
    }

    @Test
    public void testPow2() {
        Calculator calculator = new Calculator();
        assertEquals(16, calculator.pow2(4));
        assertEquals(0, calculator.pow2(0));
        assertEquals(9, calculator.pow2(-3));
    }
}
