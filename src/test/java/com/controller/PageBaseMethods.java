package com.controller;

import com.utils.UtilsController;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Random;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class PageBaseMethods extends UtilsController {

    //protected WebDriver driver;

    public PageBaseMethods(WebDriver driver){
       super(driver);
    }

    // ***************************  PageBase Utils library *************************** //

    public void navigateToApplication(){
        //Loading property file
        loadProperties();
        driver.manage().deleteAllCookies();
        driver.navigate().to(properties.getProperty("PortalUrl"));//"https://www.lordandtaylor.com");
    }

    public void clearCookies(){
        driver.manage().deleteAllCookies();
    }

    public void delay(int timeInMilli){
        try {
            Thread.sleep(timeInMilli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

    public void verifyPageTitle(String expectedPageTitle, String pageName){
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle.trim(), expectedPageTitle.trim());
        System.out.println(pageName + " Title verified...");
    }

    public void verifyPageTitleV2(String expectedPageTitle, String pageName){
        String actualPageTitle = driver.getTitle();
        assertThat(actualPageTitle, containsString(expectedPageTitle));
        System.out.println(pageName + " Title verified...");
    }

    public void typeText(By by, String text){
        WebElement element = driver.findElement(by);
        javascriptUtils().highlight(element);
        element.clear();
        element.sendKeys(text);
    }

    public void clickElement(By by){
        WebElement element = driver.findElement(by);
        javascriptUtils().highlight(element);
        element.click();
    }

    public void pressEnter(By by){
        WebElement element = driver.findElement(by);
        javascriptUtils().highlight(element);
        element.sendKeys(Keys.ENTER);
    }

    public void verifyText(By by, String expectedText){
        WebElement element = driver.findElement(by);
        javascriptUtils().highlight(element);
        String actualText = element.getText();
        System.out.println("Actual Text is : " + actualText);
        Assert.assertEquals(expectedText.trim(), actualText.trim());
    }

    public void verifyTextV2(By by, String expectedText){
        WebElement element = driver.findElement(by);
        javascriptUtils().highlight(element);
        String actualText = element.getAttribute("innerText");
        System.out.println("Actual Text is : " + actualText);
        Assert.assertEquals(expectedText.trim(), actualText.trim());
    }

    public void verifyTextIsPresent(By by, String expectedText){
        WebElement element = driver.findElement(by);
        javascriptUtils().highlight(element);
        boolean result = element.getText().contains(expectedText);
        Assert.assertTrue(result);
    }

    public void verifyValue(By by, String expectedText){
        WebElement element = driver.findElement(by);
        javascriptUtils().highlight(element);
        String actualValue = element.getAttribute("value");
        System.out.println("Actual Value is : " + actualValue);
        Assert.assertEquals(expectedText.trim(), actualValue.trim());
    }

    public void hoverToElement(WebElement element){
        javascriptUtils().highlight(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        delay(2000);
    }

    public void switchToLastOpenWindow(){
        Set<String> windowList = driver.getWindowHandles();
        String lastOpenedWindow = windowList.toArray()[windowList.size()-1].toString();
        driver.switchTo().window(lastOpenedWindow);
    }

    /**
     * Method to append random nos to email
     *
     * @return
     */
    public String generateRandomEmail() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(99999);
        String EMAIL = "username" + Integer.toString(randomInt) + "@gmail.com";
        System.out.println(EMAIL);
        return EMAIL;

    }

    public  boolean isElementDisplayed(WebElement element) {
        boolean flag=false;
        try {
            element.isDisplayed();
            flag=true;
        }catch(Exception e) {

        }
        return flag;

    }
    public  boolean isElementDisplayed(By element) {
        boolean flag=false;
        try {
            driver.findElement(element).isDisplayed();
            flag=true;
        }catch(Exception e) {

        }
        return flag;

    }
    public void waitForElementToBeVisible( WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementToBeVisible( By element){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}

