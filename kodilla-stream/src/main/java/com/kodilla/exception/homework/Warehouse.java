package com.kodilla.exception.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Warehouse {
    private Set<Order> orders;

    public Warehouse() {
        orders = new HashSet<>();
    }

    public void addOrder(String number) {
        orders.add(new Order(number));
    }

    public Order getOrder(String number) throws OrderDoesntExistException {
        List<Order> foundOrder = orders.stream()
            .filter(order -> order.getNumber().equals(number))
            .toList();

        if (foundOrder.isEmpty()) {
            throw new OrderDoesntExistException();
        }

        return foundOrder.getFirst();
    }
}
