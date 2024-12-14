package com.kodilla.stream.homework;

import com.kodilla.stream.User;
import com.kodilla.stream.UsersRepository;

import java.util.List;

public class ForumStats {
    public static double getAverageNumberOfPostsForOldUsers(List<User> users) {
        return users
            .stream()
            .filter(user -> user.getAge() >= 40)
            .mapToInt(user -> user.getNumberOfPost())
            .average()
            .orElse(-1);
    }

    public static double getAverageNumberOfPostsForYoungUsers(List<User> users) {
        return users
            .stream()
            .filter(user -> user.getAge() < 40)
            .mapToInt(user -> user.getNumberOfPost())
            .average()
            .orElse(-1);
    }

    public static void main(String[] args) {
        System.out.println("old users (>=40): " + getAverageNumberOfPostsForOldUsers(UsersRepository.getUsersList()));
        System.out.println("young users (<40): " + getAverageNumberOfPostsForYoungUsers(UsersRepository.getUsersList()));
    }
}
