package com.mycompany.app.tests;

import com.mycompany.app.pages.GoogleHomePage;
import com.mycompany.app.utils.TestFailureListener;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(TestFailureListener.class)
public class GoogleTest {

    public WebDriver driver;

    @Test
    void verifyGoogleTitle() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);

        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.open();

        assertEquals("Google", googleHomePage.getTitle());


        driver.quit();
    }
}
