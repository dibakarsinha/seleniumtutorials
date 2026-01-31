package com.mycompany.app;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTest {

    @Test
    void openGoogleTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        assertEquals("Google", driver.getTitle());

        driver.quit();
    }
}
