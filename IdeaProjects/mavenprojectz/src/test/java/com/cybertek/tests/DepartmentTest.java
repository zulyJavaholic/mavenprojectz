package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DepartmentTest {

        WebDriver driver;
        Select allDepartments;

        @BeforeClass
        public void setUpMethod() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get("https://amazon.com");
        }

        @Test(priority = 0)
        public void testDefaultValue() {
            WebElement selectElement = driver.findElement(By.id("searchDropdownBox"));

            allDepartments = new Select(selectElement);

            String selectedOption = allDepartments.getFirstSelectedOption().getText();

            Assert.assertEquals(selectedOption,"All");
        }

        @Test (priority = 1)
        public void sortAlphabetical(){
            // using the compare to method, we will compare each element in the list to the next one

            for (int i = 0; i < allDepartments.getOptions().size()-1; i++) {
                String current = allDepartments.getOptions().get(i).getText();
                String next = allDepartments.getOptions().get(i+1).getText();

                System.out.println("comparing: " + current + " with "+  next);

                Assert.assertTrue(current.compareTo(next)<=0);

            }
        }


    }

