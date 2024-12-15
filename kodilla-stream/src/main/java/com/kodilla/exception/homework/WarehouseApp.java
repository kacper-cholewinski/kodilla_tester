package com.kodilla.exception.homework;

public class WarehouseApp {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        warehouse.addOrder("xP3KkOXmb6");
        warehouse.addOrder("C9MjeIgZei");
        warehouse.addOrder("n0KC94aGow");

        try {
            warehouse.getOrder("1xX5h5lHs3");
            System.out.println("found order 1xX5h5lHs3");
        } catch (Exception e) {
            System.out.println("order 1xX5h5lHs3 does not exist");
        } finally {
            System.out.println("end of program");
        }

    }
}
