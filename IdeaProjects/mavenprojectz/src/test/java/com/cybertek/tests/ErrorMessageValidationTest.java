package com.cybertek.tests;

import com.cybertek.Pages.HomePage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorMessageValidationTest extends TestBase {
    HomePage homepage = new HomePage();

    @Test
    public void WrongEmailTest(){
        driver.get(ConfigurationReader.getProperty("url"));

       homepage.username.sendKeys("admin");
       homepage.password.sendKeys("test");

       homepage.loginButton.click();

        String error = "Invalid Login or Password.";
        String actualError = homepage.errorMessage.getText();
        Assert.assertEquals(actualError,error);

    }

    @Test
    public void wrongPasswordTest(){
         homepage.open();
         homepage.login("","test");

        homepage.username.sendKeys("Tester");
      homepage.password.sendKeys("wrong password");
        homepage.loginButton.click();

        String error = "Invalid Login or Password.";
        String actualError = homepage.errorMessage.getText();
        Assert.assertEquals(actualError,error);
    }

    @Test
    public void blankUsername(){
        homepage.open();
        homepage.login("","test");

        String error = "Invalid Login or Password.";
        String actualError = homepage.errorMessage.getText();
        Assert.assertEquals(actualError,error);
    }
}
