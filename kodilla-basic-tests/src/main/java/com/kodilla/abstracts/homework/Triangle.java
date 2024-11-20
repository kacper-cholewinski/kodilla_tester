package com.kodilla.abstracts.homework;

public class Triangle extends Shape {
    private double base;
    private double side_1;
    private double side_2;
    private double height;

    public Triangle(double base, double side_1, double side_2, double height) {
        this.base = base;
        this.side_1 = side_1;
        this.side_2 = side_2;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return base * height / 2;
    }

    @Override
    public double calculatePerimeter() {
        return base + side_1 + side_2;
    }
}
