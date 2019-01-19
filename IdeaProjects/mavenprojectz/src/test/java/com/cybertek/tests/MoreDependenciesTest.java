package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MoreDependenciesTest {

    @Test
    public void openBrowser(){
        System.out.println("opening browser");
        Assert.assertTrue(false);  // becoz this is fail so the rest which depend on this will not run
    }

    @Test(dependsOnMethods = "openBrowser")

    public void login(){
        System.out.println("login");
    }

    @Test(dependsOnMethods = "login")
    public void logOut(){
        System.out.println("logout");
    }
}
