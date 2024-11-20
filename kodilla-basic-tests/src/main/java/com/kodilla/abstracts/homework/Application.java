package com.kodilla.abstracts.homework;

public class Application {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(2.3, 5.8);
        System.out.println(rect.calculateArea());
        System.out.println(rect.calculatePerimeter());

        Square square = new Square(3.2);
        System.out.println(square.calculateArea());
        System.out.println(square.calculatePerimeter());

        Triangle triangle = new Triangle(4.1, 2.5, 3.7, 2.22357);
        System.out.println(triangle.calculateArea());
        System.out.println(triangle.calculatePerimeter());

        Person p1 = new Person("Jan", 32, new Firefighter());
        p1.displayJobResponsibilities();
        Person p2 = new Person("Agata", 28, new Accountant());
        p2.displayJobResponsibilities();
    }
}
