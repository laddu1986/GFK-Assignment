package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Laddu shashavali
 */
public class TableUtils extends UtilsController {

    public TableUtils(WebDriver driver) {
        super(driver);
    }

    // Method to retrieve texts from all the cells (All rows & columns)
    public void getAllCellText(By by){
        List<WebElement> rows = driver.findElements(by);
        for(int i=0; i<rows.size(); i++){
            WebElement row = rows.get(i);
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for(int j=0; j<cols.size(); j++){
                WebElement col = cols.get(j);
                String text = col.getText();
                System.out.println("Cell Text: " + text);
            }
        }
    }

    // Method to retrieve texts from all the cells as an Array (All rows & columns)
    public String[][] getAllCellTextArray(By by){
        String[][] tableText = null;    // declare an array called tableText
        List<WebElement> rows = driver.findElements(by); //find all the rows
        tableText = new String[rows.size()][];   //Initialize (size) the array with the total number of rows

        for(int i=0; i<rows.size(); i++){
            WebElement row = rows.get(i); //Retrieve what's in row[0]
            List<WebElement> cols = row.findElements(By.tagName("td"));
            tableText[i] = new String[cols.size()]; //Initialize (size) the array with the total number of columns for that particular row[i]
            for(int j=0; j<cols.size(); j++){
                WebElement col = cols.get(j);
                String text = col.getText();
                tableText[i][j] = text;
            }
        }
        return tableText;
    }

    // Method to retrieve texts from all the cells as an Array (All rows & columns) (Overloaded method)
    public String[][] getAllCellTextArray(WebElement element){
        String[][] tableText = null;    // declare an array called tableText
        List<WebElement> rows = element.findElements(By.xpath(".//tbody/tr")); //find all the rows
        tableText = new String[rows.size()][];   //Initialize (size) the array with the total number of rows

        for(int i=0; i<rows.size(); i++){
            WebElement row = rows.get(i); //Retrieve what's in row[0]
            List<WebElement> cols = row.findElements(By.tagName("td"));
            tableText[i] = new String[cols.size()]; //Initialize (size) the array with the total number of columns for that particular row[i]
            for(int j=0; j<cols.size(); j++){
                WebElement col = cols.get(j);
                String text = col.getText();
                tableText[i][j] = text;
            }
        }
        return tableText;
    }

}
