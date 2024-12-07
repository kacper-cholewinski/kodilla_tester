package com.kodilla.collections.adv.exercises.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlightFinder {
    private List<Flight> flightsTable;

    public FlightFinder() {
        flightsTable = FlightRepository.getFlightsTable();
    }

    public List<Flight> findFlightsFrom(String departure) {
        List<Flight> flightsFrom = new ArrayList<>();

        for (Flight flight : flightsTable) {
            if (flight.departure() == departure) {
               flightsFrom.add(flight);
            }
        }
        return flightsFrom;
    }

    public List<Flight> findFlightsTo(String arrival) {
        List<Flight> flightsTo = new ArrayList<>();

        for (Flight flight : flightsTable) {
            if (flight.arrival() == arrival) {
                flightsTo.add(flight);
            }
        }
        return flightsTo;
    }
}
