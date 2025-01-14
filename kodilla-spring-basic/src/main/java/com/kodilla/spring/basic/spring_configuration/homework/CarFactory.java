package com.kodilla.spring.basic.spring_configuration.homework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

@Configuration
public class CarFactory {
    public static Car createCarFor(Season season, LocalTime time) {
        boolean headlightsOn = !(time.getHour() >= 6 && time.getHour() < 20);
        return switch (season) {
            case SPRING, AUTUMN -> new Sedan(headlightsOn);
            case SUMMER -> new Cabrio(headlightsOn);
            case WINTER -> new SUV(headlightsOn);
        };
    }

    @Bean
    public Car createCar() {
        LocalDateTime now = LocalDateTime.now();


        Season season;
        switch (now.getMonth()) {
            case Month.JANUARY:
            case Month.FEBRUARY:
                season = Season.WINTER;
                break;

            case Month.MARCH:
                if (now.getDayOfMonth() < 21) {
                    season = Season.WINTER;
                } else {
                    season = Season.SPRING;
                }

                break;

            case Month.APRIL:
            case Month.MAY:
                season = Season.SPRING;

            case Month.JUNE:
                if (now.getDayOfMonth() < 22) {
                    season = Season.SPRING;
                } else {
                    season = Season.SUMMER;
                }

                break;

            case Month.JULY:
            case Month.AUGUST:
                season = Season.SUMMER;

            case Month.SEPTEMBER:
                if (now.getDayOfMonth() < 23) {
                    season = Season.SUMMER;
                } else {
                    season = Season.AUTUMN;
                }

                break;

            case Month.OCTOBER:
            case Month.NOVEMBER:
                season = Season.AUTUMN;

            case Month.DECEMBER:
                if (now.getDayOfMonth() < 22) {
                    season = Season.AUTUMN;
                } else {
                    season = Season.WINTER;
                }

                break;

            default:
                season = Season.SPRING;
        }

        return createCarFor(season, LocalTime.now());
    }
}
