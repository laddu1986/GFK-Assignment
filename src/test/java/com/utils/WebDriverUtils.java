package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


/**
 * Created by Laddu shashavali
 */
public class WebDriverUtils extends UtilsController{

    public WebDriverUtils(WebDriver driver) {
        super(driver);
    }

    public void printCurrentURL(){
        String url = driver.getCurrentUrl();
        System.out.println("Current Page URL: " + url);
    }

    public void printPageTitle(){
        String title = driver.getTitle();
        System.out.println("Current Page Title: " + title);
        System.out.println("----------------------------------------------------------------------");
    }

    public void printPageSource(){
        String source = driver.getPageSource();
        System.out.println("Current Page Source: \n" + source);
    }

    public void dragAndDrop(By elementFrom, By elementTo){
        WebElement from = driver.findElement(elementFrom);
        javascriptUtils().highlight(from);

        WebElement to = driver.findElement(elementTo);
        javascriptUtils().highlight(to);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(from, to).build().perform();
        delay(2000);
    }

    public void datePicker(By locatorUpToTableRow, String chosenDate) {
        List<WebElement> rows = driver.findElements(locatorUpToTableRow);
        for(WebElement row : rows){
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for(WebElement col : cols){
                String date = col.getText();
                if(date.contains(chosenDate)){
                    System.out.println(col.getText());
                    col.click();
                    break;
                }
            }
        }
    }

}
