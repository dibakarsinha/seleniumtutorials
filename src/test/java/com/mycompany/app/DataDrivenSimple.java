package com.mycompany.app;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenSimple {
    public static void main(String[] args) {
        String[][] data = {
            {"Selenium"},
            {"TestNG"},
            {"Automation"}
        };

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        for (String[] d : data) {
            driver.findElement(By.name("q")).clear();
            driver.findElement(By.name("q")).sendKeys(d[0]);
        }
        driver.quit();
    }
}
