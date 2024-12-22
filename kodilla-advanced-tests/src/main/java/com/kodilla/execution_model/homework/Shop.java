package com.kodilla.execution_model.homework;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Shop {
    private Set<Order> orders;

    public Shop() {
        orders = new HashSet<>();
    }

    public void addOrder(Order order) {
        if (order == null) {
            System.out.println("order is null");
            return;

        }

        if (order.getBuyerLogin().isBlank()) {
            System.out.println("buyer login is invalid");
            return;
        }

        if (order.getValue() <= 0) {
            System.out.println("value must be higher than 0");
            return;
        }

        orders.add(order);
    }

    public List<Order> getOrdersMadeBetween(LocalDate startDate, LocalDate endDate) throws InvalidDateRangeException {
        if (
                startDate == null
                || endDate == null
                || startDate.isAfter(endDate)
        ) {
            throw new InvalidDateRangeException();
        }

        return orders.stream()
                .filter(order -> {
                        return (order.getDate().isAfter(startDate) || order.getDate().isEqual(startDate))
                                && (order.getDate().isBefore(endDate) || order.getDate().isEqual(endDate));
                })
                .collect(Collectors.toList());
    }

    public List<Order> getOrdersWithValueBetween(double minValue, double maxValue) throws InvalidValueRangeException {
        if (minValue < 0 || maxValue <= 0 || minValue > maxValue) {
            throw new InvalidValueRangeException();
        }

        return orders.stream()
                .filter(order -> order.getValue() >= minValue && order.getValue() <= maxValue)
                .collect(Collectors.toList());
    }

    public int getNumberOfOrders() {
        return orders.size();
    }

    public double computeValueOfAllOrders() {
        return orders.stream()
                .mapToDouble(order -> order.getValue())
                .sum();
    }
}
