package com.mycompany.app.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
    // This class is intentionally left blank for future login test implementations
    public static String browser = "chrome";
    public static WebDriver driver;
    public static void main(String[] args) {
        System.out.println("LoginTest class is ready for future implementations."); 

        switch (browser) {
            case "chrome" -> {
                driver=new ChromeDriver();
                System.out.println("Chrome browser selected.");
            }
            case "firefox" -> {
                driver=new FirefoxDriver();
                System.out.println("Other browser selected.");
            }
            default -> System.out.println("No valid browser selected.");
        }
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement textBox = driver.findElement(By.ByXPath.xpath("//*[@id=\"my-text-id\"]"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        WebElement textBoxElement = driver.findElement(By.xpath("/html/body/main/div/form/div/div[1]/label[3]/textarea"));
        textBoxElement.sendKeys("This is a sample text area input.");
        textBox.sendKeys("Selenium");
        submitButton.click();
        driver.quit();
    }
}
