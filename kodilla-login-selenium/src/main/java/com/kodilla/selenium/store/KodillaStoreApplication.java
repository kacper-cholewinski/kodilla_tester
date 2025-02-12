package com.kodilla.selenium.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class KodillaStoreApplication {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium_drivers\\chrome\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://kodilla.com/pl/test/store");
        KodillaStorePom storePom = new KodillaStorePom(driver);
        storePom.searchForElements("NoteBook")
                .stream()
                .forEach(element -> System.out.println(element));

        storePom.searchForElements("nOTEbOOK")
                .stream()
                .forEach(element -> System.out.println(element));
        driver.close();
    }
}