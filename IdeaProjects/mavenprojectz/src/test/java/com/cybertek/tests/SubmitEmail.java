package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/*
 go to https://the-internet.herokuapp.com/forgot_password
 verify enter email and submit
verify email sent message on the next page
 */
public class SubmitEmail {
    public static void main(String[] args) {
        // setting driver path for chrome using the webdriver manager
        // dependency name.driverName.command
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/forgot_password");

        WebElement inputEmail = driver.findElement(By.id("email"));

        // sendKeys if for typing ,

       inputEmail.sendKeys("someemail@someemail.com"+ Keys.ENTER);

//        inputEmail.sendKeys("someemail@someemail.com");
//        inputEmail.submit();

        String expected = "Your e-mail's been sent!";

        String actual = driver.findElement(By.id("content")).getText();

        if(actual.equals(expected)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
            System.out.println("actual :"+ actual);
            System.out.println("expected :"+ expected);
        }

    }
}
