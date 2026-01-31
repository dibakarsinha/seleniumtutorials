package com.mycompany.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(TestFailureListener.class)
public class GoogleTest {

    WebDriver driver; // IMPORTANT: must be field-level

    @Test
    void openGoogleInHeadlessMode() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.get("https://www.google.com");

        // Intentionally wrong to test screenshot
        assertEquals("Google123", driver.getTitle());

        driver.quit();
    }
}
