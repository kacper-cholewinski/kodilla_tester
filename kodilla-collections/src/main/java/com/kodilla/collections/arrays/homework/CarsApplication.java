package com.kodilla.collections.arrays.homework;

import com.kodilla.collections.interfaces.homework.Car;
import com.kodilla.collections.interfaces.homework.Fiat;
import com.kodilla.collections.interfaces.homework.Ford;
import com.kodilla.collections.interfaces.homework.Volkswagen;

import java.util.Random;

public class CarsApplication {
    public static Car drawCar(Random rng) {
        int drawnCarBrand = rng.nextInt(3);
        Car drawnCar =  switch (drawnCarBrand) {
            case 0 -> new Fiat();
            case 1 -> new Ford();
            default -> new Volkswagen();
        };

        for (int i = 0; i < rng.nextInt(5) + 1; i++) {
            drawnCar.increaseSpeed();
        }

        return drawnCar;
    }

    public static void main(String[] args) {
        Random rng = new Random();
        Car[] cars = new Car[rng.nextInt(15) + 1];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = drawCar(rng);
        }

        for (Car car : cars) {
            CarUtils.describeCar(car);
        }
    }
}
