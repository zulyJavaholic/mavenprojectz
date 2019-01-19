package com.cybertek.tests;

public class Hello {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("hello");
        Thread.sleep(10000);
        System.out.println("hi");
        Thread.sleep(3000);
        System.out.println("allo");

        // when you Thread.sleep () , we have to throw InterruptedException in our main method

        // it just waits for anywhere it put , no related to finding elements or anything

    }
}
