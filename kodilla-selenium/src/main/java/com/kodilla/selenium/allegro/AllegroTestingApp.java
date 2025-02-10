package com.kodilla.selenium.allegro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AllegroTestingApp {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium_drivers\\chrome\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.ebay.com/");

        WebElement categoryDropdown = driver.findElement(By.cssSelector("#gh-search-box > div > select")); // [4]
        Select categorySelect = new Select(categoryDropdown);
        categorySelect.selectByValue("293");
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("mavic mini");
        searchBox.submit();
        new WebDriverWait(driver, 20).until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("s-item"), 0));
        List<WebElement> elements = driver.findElements(By.className("s-item"));
        elements.stream()
                .map(element -> element.findElement(By.cssSelector(".s-item__wrapper > .s-item__info > .s-item__link > .s-item__title > span")))
                .forEach(element -> System.out.println(element.getText()));
    }
}
