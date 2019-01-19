package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class WebTableExample extends TestBase {

    @Test
    public void printWholeTable() {
        login();
        WebElement table = driver.findElement(By.id("ctl00_MainContent_orderGrid"));
        System.out.println(table.getText());
    }


    public void login() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");

        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);
    }

    @Test
    public void printAllHeaders() {
        login();
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));
        // becoz its  a list, so should be findELements with plural

        for (WebElement header : headers) {
            System.out.println(header.getText());
        }
    }

    /*
    all rows including header altogether is 9
     */
    @Test
    public void printRow() {
        login();
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));

        System.out.println("number of rows" + allRows.size());
        for (WebElement rows : allRows) {
            System.out.println(rows.getText());
        }

        //print the nth row
        System.out.println("printing row" + 4);
        System.out.println(allRows.get(3).getText()); // webElements is just object , so to print , use getText

    }

    /*
    print the numbers of columns and rows
     */
    @Test
    public void printTableSize() {
        login();
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
        List<WebElement> allColumns = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]/td"));

        System.out.println("rows are " + allRows.size());
        System.out.println("columns are " + allColumns.size());
    }

    /*
    print a single row
     */
    @Test
    public void printRow2() {  // print whatever row in table
        login();
        WebElement row = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]"));
        System.out.println(row.getText());
    }

    /*
    print all cells of a row whose index is given in the xpath
     */
    @Test
    public void printAllCellsInOneRow() {
        login();
        List<WebElement> cells = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]/td"));

        for (WebElement cell : cells) {
            System.out.println(cell.getText());
        }
    }


    /*
    prints by coordinates :based on row and column number
     */
    @Test
    public void printByCoordinates() {
        login();
        WebElement cell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[6]/td[11]"));
        System.out.println(cell.getText()); // same thing 1
        System.out.println(getCell(6, 11).getText()); // same thing 2
        System.out.println(getCell2(6, 11));// same thing 3

    }

    @Test
    public WebElement getCell(int row, int col) {
        String xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[" + row + "]/td[" + col + "]";
        return driver.findElement(By.xpath(xpath));
    }

    @Test
    public String getCell2(int row, int col) {
        String xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[" + row + "]/td[" + col + "]";
        return driver.findElement(By.xpath(xpath)).getText();
    }

    /*
    prints all the values in single column
     */

    @Test
    public void printColumn() {
        login();
        List<WebElement> allNames = driver.findElements(By.xpath("/table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
        // bocoz row 1 have header th instead of td , so its excluding the first row tr[1]:Name automatically happened

        for (WebElement name : allNames) {
            System.out.println(name.getText());
        }

    }

    /*
    delete one person based on name
     */
    @Test
    public void selectCheckBox() {
        login();
        WebElement checkboxes = driver.findElement(By.xpath("//td[.='Mark Smith']/../td[1]/input"));
        System.out.println(checkboxes.isSelected());
        checkboxes.click();
        System.out.println(checkboxes.isSelected());

    }

    /*
    verify that name "someone" exists in the names column
    verify that city 'anytown' exists in the cities column
     */

    @Test
    public void test() {
        login();

        int nameIndex = getColumnIndex("Name");
        System.out.println(nameIndex);

        boolean found =false;
        List<WebElement> allNames =driver.findElements(By.xpath
                ("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td["+nameIndex+"]"));

        for(int i =0; i<allNames.size();i++){
            if(allNames.get(i).getText().equals("Mark Smith")){
                found =true;
                break;
            }
        }
        Assert.assertTrue(found);

        found =false ;
        int cityIndex = getColumnIndex("City");
        List<WebElement> allCities =driver.findElements(By.xpath
                ("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td["+cityIndex+"]"));

        for(int i =0; i<allCities.size();i++){
            if(allCities.get(i).getText().equals("Whitestone, British")){
                found =true;
                break;
            }
        }
        Assert.assertTrue(found);

    }

    public int getColumnIndex(String column) {
        List<WebElement> allHeader= driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th")); //9

        for(int i =0; i<allHeader.size();i++){
            if(allHeader.get(i).getText().equals(column))
            return i+1; // column starts from 1 while index starts from 0
        }
        return 0;
    }


}



//    public void deleteName(String name){
//        login();
//        WebElement NameToBeDeleted= driver.findElement(By.xpath("//td[.='"+name+"']"));
//
//        WebElement checkBoxToDelete= driver.findElement(By.xpath("//td[.='\"+name+\"']/..td[1]/input"));
//        System.out.println(checkBoxToDelete.isSelected());
//        checkBoxToDelete.click();
//        System.out.println(checkBoxToDelete.isSelected());
//





