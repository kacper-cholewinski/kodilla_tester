package com.kodilla.collections.adv.exercises.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlightRepository {
    public static List<Flight> getFlightsTable() {
        List<Flight> flightsTable = new ArrayList<>();

        flightsTable.add(new Flight("Warszawa", "Kraków"));
        flightsTable.add(new Flight("Warszawa", "Poznań"));
        flightsTable.add(new Flight("Kraków", "Warszawa"));
        flightsTable.add(new Flight("Gdańsk", "Warszawa"));
        flightsTable.add(new Flight("Wrocław", "Warszawa"));

        return flightsTable;
    }
}
