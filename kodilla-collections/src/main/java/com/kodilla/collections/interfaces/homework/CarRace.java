package com.kodilla.collections.interfaces.homework;

public class CarRace {
    static void doRace(Car car) {
        car.increaseSpeed();
        car.increaseSpeed();
        car.increaseSpeed();
        car.decreaseSpeed();
        car.decreaseSpeed();
        System.out.println(car.getSpeed());
    }

    public static void main(String[] args) {
        Fiat fiat = new Fiat();
        Ford ford = new Ford();
        Volkswagen vw = new Volkswagen();

        doRace(fiat);
        doRace(ford);
        doRace(vw);
    }
}
