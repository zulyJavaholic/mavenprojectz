package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RetrievePassword {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/forgot_password");

        driver.findElement(By.id("email")).sendKeys("someemail@gmail.com"+ Keys.ENTER);


        String expected = "email_sent";

       String actual = driver.getTitle();

       if(actual.contains(expected)){
           System.out.println("Pass");
       }else{
           System.out.println("Fail");
           System.out.println("actual url: "+ actual);
       }



    }
}
