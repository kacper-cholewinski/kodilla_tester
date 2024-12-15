package com.kodilla.exception.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class WarehouseTestSuite {

    @Test
    void testGetExistingOrder() throws OrderDoesntExistException {
        Warehouse warehouse = new Warehouse();
        warehouse.addOrder("xP3KkOXmb6");
        warehouse.addOrder("C9MjeIgZei");
        warehouse.addOrder("n0KC94aGow");

        warehouse.getOrder("C9MjeIgZei");

        assertTrue(true);
    }

    @Test
    void testGetNonexistentOrder() {
        Warehouse warehouse = new Warehouse();
        warehouse.addOrder("xP3KkOXmb6");
        warehouse.addOrder("C9MjeIgZei");
        warehouse.addOrder("n0KC94aGow");

        assertThrows(OrderDoesntExistException.class, () -> warehouse.getOrder("1xX5h5lHs3"));
    }
}