package com.kodilla.collections.sets.homework;

import java.util.Objects;

public class Stamp {
    String name;
    double width;
    double height;
    boolean isStamped;

    public Stamp(String name, double width, double height, boolean isStamped) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.isStamped = isStamped;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stamp stamp = (Stamp) o;
        return Double.compare(width, stamp.width) == 0 && Double.compare(height, stamp.height) == 0 && isStamped == stamp.isStamped && Objects.equals(name, stamp.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, width, height, isStamped);
    }

    @Override
    public String toString() {
        return "Stamp{" +
                "name='" + name + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", isStamped=" + isStamped +
                '}';
    }
}
