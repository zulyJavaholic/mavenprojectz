package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CraiglistTest {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.get("https://washingtondc.craigslist.org/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement searchBox = driver.findElement(By.id("query"));

        searchBox.sendKeys("corolla" + Keys.ENTER);






    }
}
