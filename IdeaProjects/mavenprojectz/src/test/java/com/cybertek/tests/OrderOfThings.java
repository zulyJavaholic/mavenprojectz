package com.cybertek.tests;

import org.testng.annotations.Test;

public class OrderOfThings {

    @Test(priority = 1)
    public void test1(){
        System.out.println("Executing 1");
    }

@Test(priority = 3)
    public void test2(){
        System.out.println("Executing 2");
    }


@Test()


    public void test3(){
        System.out.println("Executing 3");
    }


    // order in TestNG, by default ,test methods will run alphabetically
    // so to control the flow of the orders of tests,we use priority
    // @ignore on top  will not run the test
}
