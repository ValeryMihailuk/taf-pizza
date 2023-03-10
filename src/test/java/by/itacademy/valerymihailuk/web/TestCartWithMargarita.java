package by.itacademy.valerymihailuk.web;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestCartWithMargarita {
    WebDriver driver;

    @BeforeEach
    public void openTerrapizza() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(TerrapizzaPage.URL);
        WebElement btmCookies = driver.findElement(By.xpath(TerrapizzaPage.COOKIES_CLICK));
        btmCookies.click();
    }

    @Test
    public void testCard() {
        WebElement catalogPizza = driver.findElement(By.xpath(TerrapizzaPage.PAGE_PIZZA));
        catalogPizza.click();
        WebElement margarita = driver.findElement(By.xpath(TerrapizzaPage.MARGARITA_IN_PIZZA));
        margarita.click();
        WebElement card = driver.findElement(By.xpath(TerrapizzaPage.CARD));
        card.click();
        Util.waiting(5);
        String cardWithMargarita = driver.findElement(By.xpath(TerrapizzaPage.MARGARITA_IN_CARD)).getText();
        Assertions.assertEquals("Пицца Маргарита Классическая 32 см", cardWithMargarita);
    }

    @Test
    public void testCardMargaritaWithPepsi() {
        WebElement catalogPizza = driver.findElement(By.xpath(TerrapizzaPage.PAGE_PIZZA));
        catalogPizza.click();
        WebElement margarita = driver.findElement(By.xpath(TerrapizzaPage.MARGARITA_IN_PIZZA));
        margarita.click();
        WebElement beverages = driver.findElement(By.xpath(TerrapizzaPage.PAGE_BAR));
        beverages.click();
        WebElement colaInCard = driver.findElement(By.xpath(TerrapizzaPage.COLA_IN_BAR));
        colaInCard.click();
        Util.waiting(2);
        WebElement card = driver.findElement(By.xpath(TerrapizzaPage.CARD));
        card.click();
        Util.waiting(3);
        String cardWithMargarita = driver.findElement(By.xpath(TerrapizzaPage.MARGARITA_IN_CARD)).getText();
        Assertions.assertEquals("Пицца Маргарита Классическая 32 см", cardWithMargarita);
        Util.waiting(2);
        String cardWithCola = driver.findElement(By.xpath(TerrapizzaPage.COLA_IN_CARD)).getText();
        Assertions.assertEquals("Pepsi (Беларусь)", cardWithCola);
    }


    @AfterEach
    public void closeTestTerraPizza() {
        driver.quit();
    }
}
