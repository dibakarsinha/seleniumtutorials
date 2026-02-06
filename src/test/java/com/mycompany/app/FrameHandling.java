package com.mycompany.app;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FrameHandling {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1️⃣ Wait and switch to iframe
        wait.until(ExpectedConditions
                .frameToBeAvailableAndSwitchToIt(By.id("mce_0_ifr")));

        // 2️⃣ Locate TinyMCE editor body
        WebElement editor = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("tinymce"))
        );

        // 3️⃣ Clear content using keyboard (IMPORTANT)
        editor.sendKeys(Keys.CONTROL + "a");
        editor.sendKeys(Keys.DELETE);

        // 4️⃣ Type new text
        editor.sendKeys("Hello Selenium Frame Handling");

        // 5️⃣ Switch back
        driver.switchTo().defaultContent();

        driver.quit();
    }
}