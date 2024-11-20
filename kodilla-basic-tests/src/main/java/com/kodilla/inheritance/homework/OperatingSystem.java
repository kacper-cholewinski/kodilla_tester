package com.kodilla.inheritance.homework;

public class OperatingSystem {
    private int releaseYear;

    public OperatingSystem(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void turnOn() {
        System.out.println("turning system on...");
    }

    public void turnOff() {
        System.out.println("turning system off...");
    }

    public void displayReleaseYear() {
        System.out.println("this system's release year: " + releaseYear);
    }
}
