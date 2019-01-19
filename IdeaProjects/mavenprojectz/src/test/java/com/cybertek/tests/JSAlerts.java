package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlerts {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

     @AfterMethod
    public void cleanUp() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
   @Test
    public void oopsTest(){
        driver.get("https://sweetalert.js.org/");
        //trigger the pop up

       driver.findElement(By.xpath("(//button[@class='preview'])[1]")).click();

       // switch to alert, creating Alert object
       Alert alert =driver.switchTo().alert();

       alert.accept(); // clicking on an alert, okay

   }

   @Test
    public void dismiss(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Alert alert = driver.switchTo().alert();

        alert.dismiss();// clicking cancel on a pop up
   }

   @Test
   public void alertText(){
       driver.get("http://the-internet.herokuapp.com/javascript_alerts");
       driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
       Alert alert = driver.switchTo().alert();

       alert.sendKeys("Hello");// entering sth
       alert.accept();
   }

}
