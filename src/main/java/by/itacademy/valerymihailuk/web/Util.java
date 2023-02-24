package by.itacademy.valerymihailuk.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Util {


    public static void waiting(int seconds) {
        try {
            Thread.sleep(seconds * 1000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }

    public static void waitForPresenceElementXPath(WebDriver driver, String xPath, int millis) {
        new WebDriverWait(driver, Duration.ofMillis(millis))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
    }
}