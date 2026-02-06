package com.mycompany.app;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        DemoUtil.pause(2);
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        DemoUtil.pause(2);

        Alert alert = driver.switchTo().alert();
        alert.accept();
        DemoUtil.pause(2);

        driver.quit();
        DemoUtil.pause(2);
    }
}
