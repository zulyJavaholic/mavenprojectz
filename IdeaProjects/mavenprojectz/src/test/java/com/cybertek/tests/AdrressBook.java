package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdrressBook {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://a.testaddressbook.com/sign_in");

        driver.findElement(By.id("session_email")).sendKeys("kexesobepu@zsero.com");
        driver.findElement(By.id("session_password")).sendKeys("password");

        driver.findElement(By.name("commit")).click();

      String actualUserName = driver.findElement(By.className("navbar-text")).getText();
      String expectedUserName = "kexesobepu@zsero.com";

        if(actualUserName.equals(expectedUserName)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
            System.out.println("Actual user name displayed: "+actualUserName);
            System.out.println("Expeced user name:  "+  expectedUserName);
        }


    }
}
