package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MarufSession {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
// some websites are slow so we need to wait for the website to load
        // it only applies to find element method , after you run webdriver , before findElement
        // it should be before finding element to wait to complain

        // if we have multiple of waits , it will take the closest one to findElement

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);// 5 seconds slower
        driver.manage().window().fullscreen(); // to make it full screen
        driver.get("http://newtours.demoaut.com/mercurywelcome.php");

        // username :tutorial
        //password: tutorial

        driver.findElement(By.name("userName")).sendKeys("tutorial");
        driver.findElement(By.name("password")).sendKeys("tutorial");


    }
}
