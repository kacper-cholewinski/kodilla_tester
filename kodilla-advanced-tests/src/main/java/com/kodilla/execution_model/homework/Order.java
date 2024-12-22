package com.kodilla.execution_model.homework;

import java.time.LocalDate;
import java.util.Objects;

public class Order {
    private double value;
    private LocalDate date;
    private String buyerLogin;

    public Order(double value, LocalDate date, String buyerLogin) {
        this.value = value;
        this.date = date;
        this.buyerLogin = buyerLogin;
    }

    public double getValue() {
        return value;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getBuyerLogin() {
        return buyerLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(value, order.value) == 0 && Objects.equals(date, order.date) && Objects.equals(buyerLogin, order.buyerLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, date, buyerLogin);
    }
}
