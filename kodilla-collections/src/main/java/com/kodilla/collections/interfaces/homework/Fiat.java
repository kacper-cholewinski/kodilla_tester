package com.kodilla.collections.interfaces.homework;

public class Fiat implements Car {
    private int speed = 0;

    public int getSpeed() {
        return speed;
    }
    public void increaseSpeed() {
        speed += 15;
    }
    public void decreaseSpeed() {
        speed -= 10;
    }
}
