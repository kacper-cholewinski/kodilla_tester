package com.kodilla.spring.basic.spring_configuration.homework;

import com.kodilla.spring.basic.spring_dependency_injection.homework.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalTime;

@SpringBootTest
public class CarFactoryTestSuite {

    @Test
    public void testCreateCarForDaytime() {
        Car car = CarFactory.createCarFor(Season.SPRING, LocalTime.of(8, 0));
        Assertions.assertFalse(car.hasHeadlightsTurnedOn());
    }

    @Test
    public void testCreateCarForNighttime() {
        Car car = CarFactory.createCarFor(Season.SPRING, LocalTime.of(22, 0));
        Assertions.assertTrue(car.hasHeadlightsTurnedOn());
    }

    @Test
    public void testCreateCarForSpring() {
        Car car = CarFactory.createCarFor(Season.SPRING, LocalTime.of(22, 0));
        Assertions.assertEquals("sedan", car.getCarType());
    }

    @Test
    public void testCreateCarForSummer() {
        Car car = CarFactory.createCarFor(Season.SUMMER, LocalTime.of(22, 0));
        Assertions.assertEquals("cabrio", car.getCarType());
    }

    @Test
    public void testCreateCarForAutumn() {
        Car car = CarFactory.createCarFor(Season.AUTUMN, LocalTime.of(22, 0));
        Assertions.assertEquals("sedan", car.getCarType());
    }

    @Test
    public void testCreateCarForWinter() {
        Car car = CarFactory.createCarFor(Season.WINTER, LocalTime.of(22, 0));
        Assertions.assertEquals("suv", car.getCarType());
    }

    @Test
    public void testCreateCar() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        Car bean = (Car) context.getBean("createCar");
        Assertions.assertTrue(true);
    }
}
