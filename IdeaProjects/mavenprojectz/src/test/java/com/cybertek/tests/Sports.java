package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Sports {
    public static void main(String[] args) {
       /*
        1.open browser2.go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton
        3.verify that Football is selected by default and all others are not selected.
        4.Select a random sport
        5.Verify that all other options are not selected
        */


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    // find that football radio button
        WebElement football = driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Football-input"));

        System.out.println("By default,Football is selected: "+football.isSelected());// should be true

     WebElement soccer = driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Soccer-input"));
        System.out.println("Clicking on soccer");
          soccer.click();

        System.out.println("Soccer "+ soccer.isSelected()); // true

        // others are not selected
        System.out.println("Baseball "+driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Baseball-input")).isSelected());
        System.out.println("Baseball "+driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Basketball-input")).isSelected());
        System.out.println("Baseball "+driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Football-input")).isSelected());
        System.out.println("Baseball "+driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Hockey-input")).isSelected());
        System.out.println("Baseball "+driver.findElement(By.id("gwt-debug-cwRadioButton-sport-WaterPolo-input")).isSelected());



    }
}
