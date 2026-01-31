package com.mycompany.app;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestFailureListener implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {

        Object testInstance = context.getRequiredTestInstance();

        try {
            WebDriver driver = (WebDriver)
                    testInstance.getClass().getDeclaredField("driver")
                            .get(testInstance);

            File screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            Path dest = Path.of(
                    "screenshots",
                    context.getDisplayName().replace("()", "") + ".png"
            );

            Files.createDirectories(dest.getParent());
            Files.copy(screenshot.toPath(), dest);

        } catch (NoSuchFieldException | IllegalAccessException | IOException e) {
            e.printStackTrace();
        }
    }
}
