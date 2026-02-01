package com.mycompany.app.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FirstScript {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        //WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement textBox = driver.findElement(By.ByXPath.xpath("//*[@id=\"my-text-id\"]"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        WebElement textBoxElement = driver.findElement(By.xpath("/html/body/main/div/form/div/div[1]/label[3]/textarea"));
        textBoxElement.sendKeys("This is a sample text area input.");
        textBox.sendKeys("Selenium");
        submitButton.click();
        driver.quit();
    }
}