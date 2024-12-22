package com.kodilla.execution_model.homework;

import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShopTestSuite {
    Shop shop = new Shop();

    @BeforeEach
    public void initializeShop() {
        shop.addOrder(new Order(25.50, LocalDate.of(2024, 6, 23), "client_1"));
        shop.addOrder(new Order(78.30, LocalDate.of(2024, 7, 24), "client_2"));
        shop.addOrder(new Order(14.20, LocalDate.of(2024, 8, 25), "client_3"));


        shop.addOrder(new Order(14.20, LocalDate.of(2024, 8, 25), "client_3"));
        shop.addOrder(new Order(0, LocalDate.of(2024, 9, 26), "client_4"));
        shop.addOrder(new Order(-15.25, LocalDate.of(2024, 10, 27), "client_4"));
        shop.addOrder(new Order(14.20, LocalDate.of(2024, 8, 25), "   "));
        shop.addOrder(null);
    }

    @Test
    public void testChangeNumberOfOrders() {
        assertEquals(3, shop.getNumberOfOrders());
    }

    @Test
    public void testGetOrdersMadeBetween() throws InvalidDateRangeException {
        List<Order> orders = shop.getOrdersMadeBetween(
                LocalDate.of(2024, 7, 1),
                LocalDate.of(2024, 8, 1)
        );

        assertEquals(1, orders.size());
        assertEquals(
                new Order(78.30, LocalDate.of(2024, 7, 24), "client_2"),
                orders.getFirst()
        );
    }

    @Test
    public void testGetOrdersMadeBetweenInvalidDates() {
        assertThrows(InvalidDateRangeException.class, () -> shop.getOrdersMadeBetween(null, null));
        assertThrows(InvalidDateRangeException.class, () -> shop.getOrdersMadeBetween(
                LocalDate.of(2024, 7, 1),
                LocalDate.of(2024, 6, 1)
        ));
    }

    @Test
    public void testGetOrdersWithValueBetween() throws InvalidValueRangeException {
        List<Order> orders = shop.getOrdersWithValueBetween(0, 20);

        assertEquals(1, orders.size());
        assertEquals(
                new Order(14.20, LocalDate.of(2024, 8, 25), "client_3"),
                orders.getFirst()
        );
    }

    @Test
    public void testGetOrdersWithValueBetweenInvalidValues() {
        assertThrows(InvalidValueRangeException.class, () -> shop.getOrdersWithValueBetween(0, 0));
        assertThrows(InvalidValueRangeException.class, () -> shop.getOrdersWithValueBetween(-13, -5));
        assertThrows(InvalidValueRangeException.class, () -> shop.getOrdersWithValueBetween(30, 20));
    }

    @Test
    public void testComputeValueOfAllOrders() {
        assertEquals(25.50 + 78.30 + 14.20, shop.computeValueOfAllOrders(), 0.0001);
    }
}
