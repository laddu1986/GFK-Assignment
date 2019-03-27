package com.utils;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Laddu shashavali
 */
public class ExplicitWaitUtils extends UtilsController {

    public static final int DEFAULT_WAIT_TIME = 10;

    public ExplicitWaitUtils(WebDriver driver) {
        super(driver);
    }

    public FluentWait<WebDriver> fluentWait(){
        return fluentWait(DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
    }

    public FluentWait<WebDriver> fluentWait(int duration, TimeUnit timeUnit){
        return new FluentWait<WebDriver>(driver)
                .withTimeout(duration, timeUnit)
                .pollingEvery(200, TimeUnit.MILLISECONDS)
                .ignoreAll(new ArrayList<Class<? extends Throwable>>(){
                    {
                        add(StaleElementReferenceException.class);
                        add(NoSuchElementException.class);
                    }
                }).withMessage("Selenium Timeout Exception");
    }

    public WebElement waitForElement(final By locator, int timeToWaitInSeconds){

        //driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeToWaitInSeconds, TimeUnit.SECONDS)
                .pollingEvery(50, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver){
                return driver.findElement(locator);
            }
        });

        //driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_TIME, TimeUnit.SECONDS);

        return foo;
    }

    public WebElement waitForElementDisplayed(final By locator, int timeToWaitInSeconds){

        //driver.manage().timeouts().implicitlyWait(100,TimeUnit.MILLISECONDS);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeToWaitInSeconds, TimeUnit.SECONDS)
                .pollingEvery(50, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver){
                WebElement element = driver.findElement(locator);
                if(element != null && element.isDisplayed()){
                    javascriptUtils().highlight(element);
                    return element;
                }else{
                    return null;
                }
            }
        });

        //driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
        return foo;
    }

    public WebElement waitForElementDisplayed(WebElement element, int timeToWaitInSeconds){

        //driver.manage().timeouts().implicitlyWait(100,TimeUnit.MILLISECONDS);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeToWaitInSeconds, TimeUnit.SECONDS)
                .pollingEvery(10, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver){
              //  WebElement element = driver.findElement(locator);
                if(element != null && element.isDisplayed()){
                    javascriptUtils().highlight(element);
                    return element;
                }else{
                    return null;
                }
            }
        });

        //driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
        return foo;
    }
    public WebElement textToBePresentInElementLocated(By by, String textToWait, int timeToWait, TimeUnit timeUnit){
        Boolean found = false;
        WebElement element = null;
        try {
            element = driver.findElement(by);
            found = fluentWait(timeToWait, timeUnit).until(ExpectedConditions.textToBePresentInElementLocated(by, textToWait));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        if(!found) {
            System.out.println("Element with the text '" + textToWait + "' not found");
            return  null;
        }

        return element;
    }

    public void waitForVisibilityOfElement(WebElement element){
        FluentWait<WebDriver> wait = fluentWait();
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibilityOfElement(By locator){
        WebElement element = driver.findElement(locator);
        waitForVisibilityOfElement(element);
    }

    public void waitForPageTitle(String title){
        FluentWait<WebDriver> wait = fluentWait();
        wait.until(ExpectedConditions.titleIs(title));
    }

    public void waitForPageTitleContains(String title){
        FluentWait<WebDriver> wait = fluentWait();
        wait.until(ExpectedConditions.titleContains(title));
    }

    public void waitForInvisibilityOfElement(By locator){
        FluentWait<WebDriver> wait = fluentWait();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForElementAttributeContains(WebElement element,String attributeName, String attributeValue){
        FluentWait<WebDriver> wait = fluentWait();
        wait.until(ExpectedConditions.attributeContains(element,attributeName,attributeValue));
    }

    public void waitForElementAttributeContains(By locator,String attributeName, String attributeValue){
        WebElement element = driver.findElement(locator);
        waitForElementAttributeContains(element,attributeName,attributeValue);
    }

    public void waitForElementTextToBe(By locator, String text){
        FluentWait<WebDriver> wait = fluentWait();
        wait.until(ExpectedConditions.textToBe(locator,text));
    }

    public boolean isClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
