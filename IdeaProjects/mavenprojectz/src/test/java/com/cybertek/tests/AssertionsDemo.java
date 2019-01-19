package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {
    @Test
    public void test1() {
        String a = "A";
        String b = "A";

        Assert.assertEquals(a, b);// comparing a to b

    }

        @Test
        public void test2 () {
            String a = "A";
            String b = "AAA";

            Assert.assertEquals(a, b);// comparing a to b
// comparing a to b, first param is actual and second is expected

        }

@Test
        public void test3(){
//        boolean b= 1==1;
//        Assert.assertTrue(b);
        String a ="A";
        String b = "AAA";

        Assert.assertTrue(b.contains(a));

            System.out.println("done");
        }

@Test
    public void test4() {
        String a = "ADAFD";
        String b = "A";

        Assert.assertTrue(a.contains(b), b+ " should have contanied "+a);

    }
    }

