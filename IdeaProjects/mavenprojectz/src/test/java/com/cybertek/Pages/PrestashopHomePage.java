package com.cybertek.Pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrestashopHomePage {
    public PrestashopHomePage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(linkText ="Sign in")
    public WebElement signin;

    public WebElement prodcut(String productName){
        String xpath ="(//h5/a[@title='"+productName+"'])[1]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

}
