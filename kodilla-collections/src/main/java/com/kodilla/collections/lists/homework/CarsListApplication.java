package com.kodilla.collections.lists.homework;

import com.kodilla.collections.arrays.homework.CarUtils;
import com.kodilla.collections.interfaces.homework.Car;
import com.kodilla.collections.interfaces.homework.Fiat;
import com.kodilla.collections.interfaces.homework.Ford;
import com.kodilla.collections.interfaces.homework.Volkswagen;

import java.util.ArrayList;

public class CarsListApplication {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        Volkswagen vw = new Volkswagen();
        cars.add(new Ford());
        cars.add(new Fiat());
        cars.add(vw);

        for (Car car : cars) {
            CarUtils.describeCar(car);
        }

        cars.remove(0);
        cars.remove(vw);

        System.out.println("Collection's size: " + cars.size());
        for (Car car : cars) {
            CarUtils.describeCar(car);
        }
    }
}
