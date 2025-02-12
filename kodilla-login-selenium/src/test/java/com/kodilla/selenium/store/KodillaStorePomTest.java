package com.kodilla.selenium.store;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class KodillaStorePomTest {

    KodillaStorePom storePom;

    WebDriver driver;

    @BeforeEach
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://kodilla.com/pl/test/store");
        storePom = new KodillaStorePom(driver);
    }

    @Test public void testSearchForElements() {

        assertEquals(2, storePom.searchForElements("NoteBook").size());
        assertEquals(1, storePom.searchForElements("School").size());
        assertEquals(1, storePom.searchForElements("Brand").size());
        assertEquals(0, storePom.searchForElements("Business").size());
        assertEquals(1, storePom.searchForElements("Gaming").size());
        assertEquals(0, storePom.searchForElements("Powerful").size());
    }

    @Test public void testSearchForElementsUppercase() {

        assertEquals(2, storePom.searchForElements("NOTEBOOK").size());
        assertEquals(1, storePom.searchForElements("SCHOOL").size());
        assertEquals(1, storePom.searchForElements("BRAND").size());
        assertEquals(0, storePom.searchForElements("BUSINESS").size());
        assertEquals(1, storePom.searchForElements("GAMING").size());
        assertEquals(0, storePom.searchForElements("POWERFUL").size());
    }

    @AfterEach
    public void testDown() {
        driver.close();
    }
}