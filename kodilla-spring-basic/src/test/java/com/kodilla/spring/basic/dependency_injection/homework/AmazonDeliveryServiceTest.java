package com.kodilla.spring.basic.dependency_injection.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AmazonDeliveryServiceTest {
    @Test
    void testDeliverPackage() {
        DeliveryService amazonDeliveryService = new AmazonDeliveryService();

        Assertions.assertTrue(amazonDeliveryService.deliverPackage("", 10));
        Assertions.assertTrue(amazonDeliveryService.deliverPackage("", 30));
        Assertions.assertFalse(amazonDeliveryService.deliverPackage("", 31));
        Assertions.assertFalse(amazonDeliveryService.deliverPackage("", 50));
    }
}
