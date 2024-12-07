package com.kodilla.collections.adv.exercises.homework;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightFinderTestSuite {
    @Test
    public void testFindFlightsFrom() {
        FlightFinder flightFinder = new FlightFinder();

        List<Flight> foundFlights = flightFinder.findFlightsFrom("Warszawa");

        assertEquals(2, foundFlights.size());
        for (Flight flight : foundFlights) {
            assertEquals("Warszawa", flight.departure());
        }
    }

    @Test
    public void testFindFlightsTo() {
        FlightFinder flightFinder = new FlightFinder();

        List<Flight> foundFlights = flightFinder.findFlightsTo("Warszawa");

        assertEquals(3, foundFlights.size());
        for (Flight flight : foundFlights) {
            assertEquals("Warszawa", flight.arrival());
        }
    }
}