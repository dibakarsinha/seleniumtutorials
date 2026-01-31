package com.mycompany.app.pages;

import org.openqa.selenium.WebDriver;

public class GoogleHomePage {

    private WebDriver driver;

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.google.com");
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
