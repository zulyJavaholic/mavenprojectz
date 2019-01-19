package com.cybertek.tests;

/*

1. craeta a new class IframeDemo
2. go to url: https://the-internet.herokuapp.com/tinymce
3. enter text in the text editor
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeDemo {

    @Test
    public void test(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/tinymce");

      // locate iframe
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));

        // switch to iframe
        driver.switchTo().frame(iframe);

        driver.findElement(By.tagName("body")).sendKeys("abcdefg");

        driver.switchTo().parentFrame();
        // elemnetal selenium
        driver.findElement(By.linkText("Elemental Selenium")).click();

    }
}
