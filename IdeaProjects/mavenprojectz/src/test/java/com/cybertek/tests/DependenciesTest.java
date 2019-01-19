package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependenciesTest {

    @Test
    public void login(){
        System.out.println("login");
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = "login")
    public void zbuySth(){
        System.out.println("Buy buy baby");
    }

    @Test(priority = 5)
    public void homePage(){
        System.out.println("home page");
    }


    // becoz zbuySth depends on logIn method , so if login Fails , zbuySth will be ignored, not executed at all
    // coz there is no point of running the test
}
