package com.mycompany.app;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionTest {
    @Test
    public void verifyTitle() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        Assert.assertEquals(driver.getTitle(), "Google");
        driver.quit();
    }
}
