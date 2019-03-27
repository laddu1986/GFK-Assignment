package com.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.Locatable;

import java.util.NoSuchElementException;

/**
 * Created by Laddu shashavali
 */
public class MouseUtils extends UtilsController {

    public MouseUtils(WebDriver driver) {
        super(driver);
    }

    //Method to Hover over an element
    public void hoverAction(WebElement element){
        javascriptUtils().highlight(element);
        delay(2000);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    //Mouse Hover element with Locatable and Mouse class
    public void hoverLocatable(WebElement element){
        javascriptUtils().highlight(element);
        Locatable hoverItem = (Locatable) element;
        Mouse mouse = ((HasInputDevices) driver).getMouse();
        mouse.mouseMove(hoverItem.getCoordinates());
    }

    //Method to hover over an element using JavaScript Executor
    public void mouseHoverJScript(WebElement HoverElement) {
        javascriptUtils().highlight(HoverElement);
        try {
            if (isElementPresent(HoverElement)) {
                String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
                ((JavascriptExecutor) driver).executeScript(mouseOverScript, HoverElement);
            } else {
                System.out.println("Element was not visible to hover " + "\n");
            }

        } catch (StaleElementReferenceException e) {
            System.out.println("Element with " + HoverElement
                    + "is not attached to the page document"
                    + e.getStackTrace());
        }
    }

    public static boolean isElementPresent(WebElement element) {
        boolean flag = false;
        try {
            if (element.isDisplayed()
                    || element.isEnabled())
                flag = true;
        } catch (NoSuchElementException e) {
            flag = false;
        } catch (StaleElementReferenceException e) {
            flag = false;
        }
        return flag;
    }

}
