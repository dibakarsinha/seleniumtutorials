package com.mycompany.app;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTest {

    @Test
    void openGoogleInHeadlessMode() {

       boolean isHeadless = Boolean.parseBoolean(
        System.getProperty("headless", "false"));

ChromeOptions options = new ChromeOptions();
if (isHeadless) {
    options.addArguments("--headless=new");
}
options.addArguments("--no-sandbox");
options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");

        assertEquals("Google", driver.getTitle());

        driver.quit();
    }
}
