package com.kodilla.spring.basic.spring_scopes.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClockTestSuite {

    ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
    Clock firstBean = context.getBean(Clock.class);
    Clock secondBean = context.getBean(Clock.class);
    Clock thirdBean = context.getBean(Clock.class);

    @Test
    public void testIfItIsNotTheSameBean() {
        Assertions.assertNotEquals(firstBean, secondBean);
        Assertions.assertNotEquals(thirdBean, secondBean);
        Assertions.assertNotEquals(firstBean, thirdBean);
    }

    @Test
    public void testGetCurrentTime() {
        Assertions.assertNotEquals(firstBean.getCreationTime(), secondBean.getCreationTime());
        System.out.println("first passed");
        Assertions.assertNotEquals(firstBean.getCreationTime(), thirdBean.getCreationTime());
        System.out.println("second passed");
        Assertions.assertNotEquals(secondBean.getCreationTime(), thirdBean.getCreationTime());
    }
}
