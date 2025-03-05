package com.kodilla.abstracts;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DuckTest {
    @Test
    void testGetNumberOfLegs() {
        Duck duck = new Duck();

        Assertions.assertEquals(2, duck.getNumberOfLegs());
    }
}
