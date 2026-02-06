package com.mycompany.app;

public class DemoUtil {

    // Slow motion delay (change once, affects all programs)
    public static int DEMO_DELAY = 2; // seconds

    public static void pause() {
        try {
            Thread.sleep(DEMO_DELAY * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Optional: show step in console
    public static void step(String message) {
        System.out.println("👉 " + message);
        pause();
    }
}