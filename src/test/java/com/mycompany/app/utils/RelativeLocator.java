package com.mycompany.app.utils;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RelativeLocator {

    // This class is intentionally left blank for future login test implementations
    public static String browser = "chrome";
    public static WebDriver driver;

    public static void main(String[] args) {
        System.out.println("LoginTest class is ready for future implementations.");

        switch (browser) {
            case "chrome" -> {
                driver = new ChromeDriver();
                System.out.println("Chrome browser selected.");
            }
            case "firefox" -> {
                driver = new FirefoxDriver();
                System.out.println("Other browser selected.");
            }
            default ->
                System.out.println("No valid browser selected.");
        }
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        // Text box
        WebElement textBox = driver.findElement(By.id("my-text-id"));
        textBox.sendKeys("Selenium");

// Text area
        WebElement textArea = driver.findElement(By.name("my-textarea"));
        textArea.sendKeys("This is a sample text area input.");

// File upload
        URL resource = RelativeLocator.class
                .getClassLoader()
                .getResource("selenium-snapshot.png");

        if (resource == null) {
            throw new RuntimeException("File not found in resources folder");
        }
        File uploadFile = null;
        try {
             uploadFile = new File(resource.toURI());
        } catch (URISyntaxException ex) {
            System.getLogger(RelativeLocator.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        if (uploadFile != null) {
            System.out.println("File exists? " + uploadFile.exists());
            driver.findElement(By.name("my-file"))
              .sendKeys(uploadFile.getAbsolutePath());
        } else {
            System.out.println("File upload failed: uploadFile is null.");
        }  
        

// Submit button
        driver.findElement(By.cssSelector("button")).click();

        driver.quit();

    }
}
