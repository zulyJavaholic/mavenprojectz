package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ReallyCheckboxes {
    public static void main(String[] args) {
          /*
    verify monday is not selected
    select monday
    verify monday is selected
    unselect monday
     */
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");

       WebElement monday = driver.findElement(By.id("gwt-debug-cwCheckBox-Monday-input"));// inspect the checkbox
       System.out.println(monday.isSelected()); // false
        monday.click(); //then you check it
       System.out.println(monday.isSelected()); // true

        monday.click();// it should uncheck monday
        System.out.println(monday.isSelected()); // false

        if(!monday.isSelected()){
            monday.click();// it should check monday
        }

        System.out.println(monday.isSelected()); // true

    }
}
