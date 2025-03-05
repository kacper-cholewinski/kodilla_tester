package com.kodilla.abstracts;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DogTest {
    @Test
    void testGetNumberOfLegs() {
        Dog dog = new Dog();

        Assertions.assertEquals(4, dog.getNumberOfLegs());
    }
}
