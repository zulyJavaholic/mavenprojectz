package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionExample {

    @Test
    public void test1() {
        System.out.println("starting");

        Assert.assertTrue(false);

        System.out.println("done");
        // assertTrue is pass becoz of true , so done was printed
        // if you make it false,it fails so it will stop , it breaks the code and stop it from executing ,
        // so done will not be printed
    }

    @Test
    public void test2() {
        SoftAssert softAssert = new SoftAssert(); // it doesnt stop

        System.out.println("starting");

        softAssert.assertTrue(false);// fail

        softAssert.assertEquals("google", "etsy");// fail

        System.out.println("done");
        softAssert.assertAll();

    }

    @Test
    public void test3() {
        SoftAssert softAssert = new SoftAssert(); // it doesnt stop

        System.out.println("starting");

        softAssert.assertTrue(false);

        Assert.assertTrue(false); // it stops here

        System.out.println("done");
        softAssert.assertAll();

    }
}
