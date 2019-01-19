package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.*;


import java.util.concurrent.TimeUnit;

public class Departments {
    public static void main(String[] args) {
        /*
        1.open browser 2.go to https://amazon.com 3.verify that default dropdown option is all
        4.verify that all options are sorted alphabetically
        5.Click on the menu icon on the left 6.click on Full Store directory
        7.capture all of the main department namesin the page. Examples for main department pages shown in the picture.
        8.verify that departments names are sorted alphabetically
        9.verify that all departments names are listed in the dropdown from step 2
         */
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://amazon.com");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // find the dropdown element byId
       WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));

       //get access to the lists in dropdown
       Select list = new Select(dropDown);
       // get default option which is the first one in the list
       String actualDefault = list.getFirstSelectedOption().getText();

        String expected = "All Departments";

        if(actualDefault.equals(expected)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
            System.out.println("expected "+expected);
            System.out.println("Actual "+ actualDefault);
        }

//4. verify that all options are sorted alphabetically
       List<WebElement> options= list.getOptions();

//5. Click on the menu icon on the left

  driver.findElement(By.className("hm-icon nav-sprite")).click();






    }
}
