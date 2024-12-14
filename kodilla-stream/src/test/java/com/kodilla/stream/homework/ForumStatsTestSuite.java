package com.kodilla.stream.homework;

import com.kodilla.stream.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ForumStatsTestSuite {
    @Test
    public void testGetAverageNumberOfPostsForOldUsers() {
        List<User> users = new ArrayList<>(Arrays.asList(
            new User("Khalil Bridges", 31, 215, "A"),
            new User("Thiago Shepherd", 17, 385, "B"),
            new User("Kasen Rasmussen", 58, 2, "C"),
            new User("Emery McKenzie", 47, 98, "A")
        ));

        assertEquals(50., ForumStats.getAverageNumberOfPostsForOldUsers(users), 0.001);

        List<User> emptyUsers = new ArrayList<>();
        assertEquals(-1, ForumStats.getAverageNumberOfPostsForOldUsers(emptyUsers), 0.001);
    }

    @Test
    public void testGetAverageNumberOfPostsForNewUsers() {
        List<User> users = new ArrayList<>(Arrays.asList(
                new User("Khalil Bridges", 31, 215, "A"),
                new User("Thiago Shepherd", 17, 385, "B"),
                new User("Kasen Rasmussen", 58, 2, "C"),
                new User("Emery McKenzie", 47, 98, "A")
        ));

        assertEquals(300., ForumStats.getAverageNumberOfPostsForYoungUsers(users), 0.001);

        List<User> emptyUsers = new ArrayList<>();
        assertEquals(-1, ForumStats.getAverageNumberOfPostsForYoungUsers(emptyUsers), 0.001);
    }
}
