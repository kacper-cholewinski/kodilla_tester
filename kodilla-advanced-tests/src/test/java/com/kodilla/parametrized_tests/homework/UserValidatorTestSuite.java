package com.kodilla.parametrized_tests.homework;

import com.kodilla.parametrized_tests.StringValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserValidatorTestSuite {

    @ParameterizedTest
    @ValueSource(strings = {
        /* wielkie litery */ "USERNAME",
        /* małe litery */ "username",
        /* mieszane litery */ "UsErNAme",
        /* litery i cyfry */ "Username123",
        /* same cyfry */ "123456789",
        /* litery, cyfry i dozwolone znaki specjalne */ "23u_s-E.Rname1",
        /* same dozwolone znaki specjalne */ "___...---",
        /* minimalna długość */ "abc",
        /* wysoka długość */ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    })
    public void validateUsernameShouldReturnTrue(String username) {
        assertTrue(UserValidator.validateUsername(username));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            /* poniżej minimalnej długości */ "Ab",
            /* poniżej minimalnej długości */ "a",
            /* same niedozwolone znaki specjalne */ "*&^%$",
            /* litery i niedozwolone znaki specjalne */ "u%s$e#r!",
            /* spacja w środku */ "username 123",
            /* same spacje */ "     ",
            /* enter w środku */ "username\n123",
            /* same entery */ "\n\n\n\n"
    })
    public void validateUsernameShouldReturnFalse(String username) {
        assertFalse(UserValidator.validateUsername(username));
    }

    @ParameterizedTest
    @ValueSource(strings = {
        /* klasyk */ "user@mail.com",
        /* krótkie części */ "u@m.c",
        /* dozwolone znaki specjalne */ "us.erna_me@ma-il.com",
        /* wielkie litery */ "USER@MAIL.COM",
        /* długie części */ "usernameusernameusername@mailmailmailmail.com",
    })
    public void validateEmailShouldReturnTrue(String email) {
        assertTrue(UserValidator.validateEmail(email));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
        /* bez domeny */ "user",
        /* bez domeny niższego poziomu */ "user.com",
        /* bez domeny wyższego poziomu */ "user@mail",
        /* sama domena */ "@mail.com",
        /* niedozwolone znaki specjalne */ "u$er@ma!l.com",
        /* kilka "małp" */ "user@name@mail.com",
        /* znaki specjalne w domenie wyższego poziomu */ "user@mail.c-o_m",
        /* same znaki specjalne */ "!#$%@^&*(.)^!",
        /* spacje w środku części */ "us er@mail.com", "user@ma il.com", "user@mail.co m",
        /* spacje między częściami */ "user@ mail.com", "user@mail .com"
    })
    public void validateEmailShouldReturnFalse(String email) {
        assertFalse(UserValidator.validateEmail(email));
    }
}