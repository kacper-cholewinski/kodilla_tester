package com.kodilla.collections.interfaces.homework;

public class Volkswagen implements Car {
    private int speed = 0;

    public int getSpeed() {
        return speed;
    }
    public void increaseSpeed() {
        speed += 20;
    }
    public void decreaseSpeed() {
        speed -= 15;
    }
}
