package by.itacademy.valerymihailuk.web;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.time.Duration.*;

public class TestCartWithMargarita {
    WebDriver driver;
    @BeforeAll
    public void openTerrapizza ()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get(TerrapizzaPage.URL);
    }
@Test
    public static void testCard () {

}

}
