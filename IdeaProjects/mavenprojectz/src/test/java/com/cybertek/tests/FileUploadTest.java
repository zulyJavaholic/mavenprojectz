package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase {

    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/upload");
        // locate chooseFile
        WebElement chooseFile= driver.findElement(By.id("file-upload"));

        String path = "/Users/zulhumaryusanov/Downloads/test.txt";

        chooseFile.sendKeys(path);// you click and choose one file and hit open so its like enterring a file
        driver.findElement(By.id("file-submit")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h3[.='File Uploaded!']")).isDisplayed());
    }
}
