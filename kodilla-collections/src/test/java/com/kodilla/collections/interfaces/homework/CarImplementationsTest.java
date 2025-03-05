package com.kodilla.collections.interfaces.homework;

import com.kodilla.collections.arrays.homework.CarsApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class CarImplementationsTest {
    Car car = CarsApplication.drawCar(new Random());

    @Test
    void testIncreaseSpeed() {
        int initialCarSpeed = car.getSpeed();
        car.increaseSpeed();
        Assertions.assertTrue(car.getSpeed() > initialCarSpeed);
    }

    @Test
    void testDecreaseSpeed() {
        int initialCarSpeed = car.getSpeed();
        car.decreaseSpeed();;
        Assertions.assertTrue(car.getSpeed() < initialCarSpeed);
    }
}
