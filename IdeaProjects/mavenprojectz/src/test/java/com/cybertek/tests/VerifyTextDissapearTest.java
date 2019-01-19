package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTextDissapearTest extends TestBase {

    @Test
    public void verify1() {
        driver.get("https://www.w3schools.com/howto/howto_js_toggle_hide_show.asp");

        // locate that area that is not showing anything
        WebElement text = driver.findElement(By.id("myDIV"));
        System.out.println(text.getText());

        Assert.assertTrue(text.isDisplayed());

        driver.findElement(By.xpath("//button[@class='w3-btn w3-hover-black w3-dark-grey']")).click();

        Assert.assertFalse(text.isDisplayed());// elements exisit but not visible

    }

    @Test
    public void verify2() {
        driver.get("https://www.w3schools.com/jquery/tryit.asp?filename=tryjquery_html_remove");
        driver.switchTo().frame("iframeResult");

        WebElement text = driver.findElement(By.xpath("//html/body/p"));

        System.out.println(text.getText());

        Assert.assertTrue(text.isDisplayed());

        driver.findElement(By.xpath("//button[.='Remove all p elements']")).click(); // they are removed from html

          Assert.assertFalse(elementDisplayed(By.id("//html/body/p")));
    }

    /*
    Takes a locator and returns if element matching this locator exists
     */
    public boolean elementDisplayed(By by) {
        // try find it
        // if cant find it , return false
        try {
           return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public boolean elementDisplayedS(By by){
        return driver.findElements(by).isEmpty();
        // isEmpty is for a list , so should be findElements with plural
    }
}