package com.kodilla.spring.basic.spring_dependency_injection.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class ShippingCenterTestSuite {
    ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
    ShippingCenter bean = context.getBean(ShippingCenter.class);
    String address = "placeholder";

    @Test
    public void testSendPackageSuccess() {
        Assertions.assertEquals("Package delivered to: " + address, bean.sendPackage(address, 20));
    }

    @Test
    public void testSendPackageFailure() {
        Assertions.assertEquals("Package not delivered to: " + address, bean.sendPackage(address, 40));
    }
}
