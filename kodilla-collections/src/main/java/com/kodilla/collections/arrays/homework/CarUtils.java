package com.kodilla.collections.arrays.homework;

import com.kodilla.collections.interfaces.homework.Car;
import com.kodilla.collections.interfaces.homework.Fiat;
import com.kodilla.collections.interfaces.homework.Ford;
import com.kodilla.collections.interfaces.homework.Volkswagen;

public class CarUtils {
    public static void describeCar(Car car) {
        System.out.println("Car's brand: " + getShapeName(car));
        System.out.println("Car's current speed: " + car.getSpeed());
    }

    private static String getShapeName(Car car) {
        if (car instanceof Fiat)
            return "Fiat";
        else if (car instanceof Ford)
            return "Ford";
        else if (car instanceof Volkswagen)
            return "Volkswagen";
        else
            return "Unknown shape name";
    }
}
