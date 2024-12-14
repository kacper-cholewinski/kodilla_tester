package com.kodilla.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UsersManagerTest {
    @Test
    public void testFilterChemistGroupUsernames() {
        List<String> actualChemists = UsersManager.filterChemistGroupUsernames();
        List<String> expectedChemists = new ArrayList<>(Arrays.asList("Gale Boetticher", "Walter White"));

        assertTrue(expectedChemists.containsAll(actualChemists));
        assertTrue(actualChemists.containsAll(expectedChemists));
        assertEquals(actualChemists.size(), expectedChemists.size());
    }

    @Test
    public void testFilterAboveGivenAge() {
        List<User> usersAboveGivenAge = UsersManager.filterAboveGivenAge(35);

        assertTrue(usersAboveGivenAge.stream().allMatch(user -> user.getAge() > 35));
    }

    @Test
    public void testFilterBelowPostLimit() {
        List<User> usersBelowPostLimit = UsersManager.filterBelowPostLimit(100);

        assertTrue(usersBelowPostLimit.stream().allMatch(user -> user.getNumberOfPost() < 100));
    }
}
