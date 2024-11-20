package com.kodilla.inheritance.homework;

public class Application {
    public static void main(String[] args) {
        OperatingSystem operatingSystem = new OperatingSystem(2005);
        operatingSystem.turnOn();
        operatingSystem.turnOff();
        operatingSystem.displayReleaseYear();

        Windows10 win10 = new Windows10();
        win10.turnOn();
        win10.turnOff();
        win10.displayReleaseYear();

        Windows11 win11 = new Windows11();
        win11.turnOn();
        win11.turnOff();
        win11.displayReleaseYear();
    }
}
