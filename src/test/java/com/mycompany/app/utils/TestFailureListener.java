package com.mycompany.app.utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class TestFailureListener implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {

        try {
            Object testInstance = context.getRequiredTestInstance();
            WebDriver driver = (WebDriver)
                    testInstance.getClass().getField("driver")
                            .get(testInstance);

            if (driver == null) {
                System.out.println("Driver is null, screenshot skipped");
                return;
            }

            File screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            Path destination = Path.of(
                    "screenshots",
                    context.getRequiredTestMethod().getName()
                            + "_" + System.currentTimeMillis() + ".png"
            );

            Files.createDirectories(destination.getParent());
            Files.copy(
                    screenshot.toPath(),
                    destination,
                    StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println("Screenshot saved at: " + destination);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
