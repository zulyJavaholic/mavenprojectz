package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TabExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/windows");
    }

   // @AfterMethod
    public void cleanUp() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
/*
test case :
go to https://the-internet.herokuapp.com/windows
click on "click here"

verify that new title is "New Windows"
verify that new title is not "The Internet"
 */
    @Test
    public void changeTab(){

        System.out.println(driver.getWindowHandles().size());  // handling one tab

        driver.findElement(By.linkText("Click Here")).click();

        System.out.println(driver.getWindowHandles().size()); // now handling two
        // change to the new tab
        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println("-------------------------------");
        for(String handle:windowHandles){
            //System.out.println(handle);

            driver.switchTo().window(handle);
           // System.out.println(driver.getTitle());

            if(driver.getTitle().equals("New Window")){
               break;
            }
        }

        Assert.assertEquals(driver.getTitle(),"New Window");

        Assert.assertNotEquals(driver.getTitle(),"The Internet");
    }

/*
go to https://www.w3schools.com/html/
click on Try it Yourself
verify the url of the new tab contains "default"
 */

@Test
    public void changeTab2(){
    driver.get("https://www.w3schools.com/html/");
    driver.findElement(By.partialLinkText("Try it Yourself")).click();

    // title of the econd Tryit Editor v3.6
    // get teh handles
    // switch 1 by  1
    // if the title is the right one , break the loop

    for(String handle: driver.getWindowHandles()){
        driver.switchTo().window(handle);
            if(driver.getTitle().equals("Tryit Editor v3.6")){
                break;
            }
        }
    Assert.assertTrue(driver.getCurrentUrl().contains("default"));

    System.out.println(driver.getWindowHandles().size()); // how many windows :2

    driver.close();

    System.out.println(driver.getWindowHandles().size()); // 1
    }
}

