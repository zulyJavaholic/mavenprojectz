package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Days {
    public static void main(String[] args) {
        /*
        1.open browser 2.go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox
        3.Randomly select days of the week. As soon as you check any day, print the name of the day and uncheck immediately
        .After you check and uncheck Friday for the third time, exit the program
         */

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //find an element
      WebElement monday = driver.findElement(By.id("gwt-debug-cwCheckBox-Monday-input"));
      //check
      monday.click();
      //name of the day and check if checked
        System.out.println(driver.findElement(By.id("gwt-debug-cwCheckBox-Monday-label")).getText()+"is selected: " +monday.isSelected());
        monday.click();
        System.out.println(monday.isSelected());


        WebElement wednesday = driver.findElement(By.id("gwt-debug-cwCheckBox-Wednesday-input"));
        wednesday.click();
        System.out.println(driver.findElement(By.id("gwt-debug-cwCheckBox-Wednesday-label")).getText()+ "is selected: "+ wednesday.isSelected());
        wednesday.click();
        System.out.println(wednesday.isSelected());// false


        WebElement friday = driver.findElement(By.id("gwt-debug-cwCheckBox-Friday-input"));
        friday.click();
        System.out.println(driver.findElement(By.id("gwt-debug-cwCheckBox-Friday-label")).getText()+ "is selected: "+ friday.isSelected());
        friday.click();
        System.out.println(friday.isSelected());// false

        driver.close();



    }
}
