package com.kodilla.spring.basic.spring_configuration.homework;

public class Sedan implements Car {
    private boolean headlightsOn;

    public Sedan(boolean headlightsOn) {
        this.headlightsOn = headlightsOn;
    }

    @Override
    public boolean hasHeadlightsTurnedOn() {
        return headlightsOn;
    }

    @Override
    public String getCarType() {
        return "sedan";
    }
}
