package com.kodilla.spring.basic.spring_dependency_injection.homework;

import com.kodilla.spring.basic.spring_dependency_injection.SkypeMessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class CalculatorTestSuite {

    ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
    Calculator bean = context.getBean(Calculator.class);

    @Test
    public void testAdd() {
        double result = bean.add(2.5, 7.3);
        Assertions.assertEquals(9.8, result, 0.01);
    }

    @Test
    public void testSubtract() {
        double result = bean.subtract(7.3, 2.5);
        Assertions.assertEquals(4.8, result, 0.01);
    }

    @Test
    public void testMultiply() {
        double result = bean.multiply(2.5, 4);
        Assertions.assertEquals(10, result, 0.01);
    }

    @Test
    public void testDivide() {
        double result = bean.divide(3.8, 2);
        Assertions.assertEquals(1.9, result, 0.01);
    }

    @Test
    public void testDivideByZero() {
        double result = bean.divide(3.8, 0);
        Assertions.assertEquals(Double.POSITIVE_INFINITY, result, 0.01);
    }
}
