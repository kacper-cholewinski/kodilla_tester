package com.kodilla.spring.basic.spring_scopes.homework;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@Scope("prototype")
public class Clock {
    private LocalTime creationTime;

    public Clock() {
        creationTime = LocalTime.now();
    }

    public LocalTime getCreationTime() {
        return creationTime;
    }
}
