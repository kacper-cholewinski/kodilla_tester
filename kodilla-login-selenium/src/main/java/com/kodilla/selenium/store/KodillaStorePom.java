package com.kodilla.selenium.store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class KodillaStorePom {

    @FindBy(css = "input[type='text']")
    WebElement searchBox;

    WebDriver driver;

    public KodillaStorePom(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<String> searchForElements(String phrase) {
        searchBox.clear();
        searchBox.sendKeys(phrase);
        List<WebElement> elements = driver.findElements(By.className("element"));

        return elements.stream()
                .map(element -> element.findElement(By.cssSelector(".header > h3")).getText())
                .collect(Collectors.toList());
    }
}