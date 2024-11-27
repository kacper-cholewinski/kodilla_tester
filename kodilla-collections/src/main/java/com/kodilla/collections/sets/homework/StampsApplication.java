package com.kodilla.collections.sets.homework;

import java.util.HashSet;
import java.util.Set;

public class StampsApplication {
    public static void main(String[] args) {
        Set<Stamp> stamps = new HashSet<>();

        stamps.add(new Stamp("a", 5, 8, false));
        stamps.add(new Stamp("b", 7, 10, true));
        stamps.add(new Stamp("c", 6, 8, true));
        stamps.add(new Stamp("a", 5, 8, false));

        System.out.println("set size: " + stamps.size());
        for (Stamp stamp : stamps) {
            System.out.println(stamp);
        }
    }
}
