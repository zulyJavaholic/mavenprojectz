package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SwitchOptions {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/tinymce");
    }

    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }

    @Test
    public void switchByElement(){
        // locate iframe
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));

        // switch to iframe
        driver.switchTo().frame(iframe);

        driver.findElement(By.tagName("body")).sendKeys("abcdefg");

    }

   @Test
   public void switchById(){
       // switch to the frame found by locator

       driver.switchTo().frame("mce_0_ifr");

       driver.findElement(By.tagName("body")).sendKeys("abcdefg");
   }

    @Test
    public void switchByIndex(){
        // switch to the frame found by locator

        driver.switchTo().frame(0); // zero bases index

        driver.findElement(By.tagName("body")).sendKeys("abcdefg");
    }

}
