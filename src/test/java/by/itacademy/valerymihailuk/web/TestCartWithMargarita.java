package by.itacademy.valerymihailuk.web;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCartWithMargarita {
    WebDriver driver;

    @BeforeEach
    public void openTerrapizza() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get(TerrapizzaPage.URL);
    }

    @Test
    public void testCard() {
        WebElement catalogPizza = driver.findElement(By.xpath(TerrapizzaPage.PAGE_PIZZA));
        catalogPizza.click();
        WebElement margarita = driver.findElement(By.xpath(TerrapizzaPage.MARGARITA_IN_PIZZA));
        margarita.click();
        WebElement card = driver.findElement(By.xpath(TerrapizzaPage.CARD));
        card.click();
        WebElement cardWithMargarita = driver.findElement(By.xpath(TerrapizzaPage.MARGARITA_IN_CARD));
        Assertions.assertEquals("Пицца Маргарита", cardWithMargarita);
    }

    @AfterEach
    public void closeTestTerraPizza() {
        driver.quit();
    }
}
