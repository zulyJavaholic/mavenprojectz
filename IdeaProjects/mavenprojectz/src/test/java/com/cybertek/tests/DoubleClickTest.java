package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleClickTest extends TestBase {

    @Test
    public void test(){
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        driver.switchTo().frame("iframeResult");
        // create actions object
        Actions actions = new Actions(driver); // for Actions you need to pass driver as param

        //identify the webelement on which double click
        WebElement text = driver.findElement(By.id("demo"));
        // double click on elemnt
        // we need to add perform at the end of any action
        actions.doubleClick(text).perform();

        Assert.assertTrue(text.getAttribute("style").contains("red"));









    }
}
