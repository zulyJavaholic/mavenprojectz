package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {
    /*
    open browser
    go to amazon
    enter search term and submit
    verify search box still contains the same search term

     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        WebElement input = driver.findElement(By.id("twotabsearchtextbox"));

        input.sendKeys("charger"+Keys.ENTER);

        String searchTerm ="charger";

        String actualTerm = driver.findElement(By.id("twotabsearchtextbox")).getAttribute("value");

        if(searchTerm.equals(actualTerm)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
            System.out.println("actual :"+ searchTerm);
            System.out.println("expected :"+ actualTerm);
        }

    }
}

