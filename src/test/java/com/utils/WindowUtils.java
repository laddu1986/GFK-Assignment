package com.utils;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by Laddu shashavali
 */
public class WindowUtils extends UtilsController {

    public WindowUtils(WebDriver driver) {
        super(driver);
    }

    public String getLastWindowHandle(){
        Set<String> listOfWindows = driver.getWindowHandles();
        return listOfWindows.toArray()[listOfWindows.size()-1].toString(); //Returns the last windows as a string
    }

    public void switchToLastWindow(){
        String win = getLastWindowHandle(); //Calls the previous method to get the last window
        driver.switchTo().window(win); //Switches to the "win"(the last window -- #2 in this case) window
    }

    public void closeLastWindow(){
        switchToLastWindow(); //Switch to last window using the previous method
        driver.close();
    }

    //Method to switch to a window by using the "page title"
    public void switchToWindow(String winTitle){
        Set<String> winHandles = driver.getWindowHandles(); //Provides a set of all the windows that has opened
        Iterator<String> iterator = winHandles.iterator();  //To iterate through the Set of elements
        while (iterator.hasNext()){
            String win = iterator.next(); //To get the next window as a String
            driver.switchTo().window(win); //Switch to the next window
            String currentPageTitle = driver.getTitle();
            if(currentPageTitle.contains(winTitle)){
                return;
            }
        }
        throw new RuntimeException("Window with the Title contain '" + winTitle + "' not found.");
    }

    //Method to switch to a window by using the "page URL"
    public void switchToWindowbyURL(String url){
        Set<String> winHandles = driver.getWindowHandles(); //Provides a set of all the windows that has opened
        Iterator<String> iterator = winHandles.iterator();  //To iterate through the Set of elements
        while (iterator.hasNext()){
            String win = iterator.next(); //To get the next window as a String
            driver.switchTo().window(win); //Switch to the next window
            String currentURL = driver.getCurrentUrl(); //Get the current page's URL
            if(currentURL.contains(url)){
                return;
            }
        }
        throw new RuntimeException("Window with the URL '" + url + "' not found.");
    }

    //Method to switch to a window by using the "page Index" (Overloaded Method) (But how to get the index -- Ask teacher... P.S: 0 and 1 isn't working)
    public void switchToWindow(int winIndex){
        Set<String> winHandles = driver.getWindowHandles(); //Provides a set of all the windows that has opened

        if(winIndex < winHandles.size()){
            String win = winHandles.toArray()[winIndex].toString();
            driver.switchTo().window(win);
        }

        throw new RuntimeException("Window with the index '" + winIndex + "' not found.");
    }

    //Method to close a window with a given Title
    public void closeWindow(String title){
        switchToWindow(title); //Switch to the window with the given title
        driver.close();
        switchToLastWindow();
    }

    //Method to close a window with a given Index (But how to get the index -- Ask teacher... P.S: 0 and 1 isn't working)
    public void closeWindow(int winIndex){ //Overloaded Method
        switchToWindow(winIndex); //Switch to the window with the given Index
        driver.close();
        switchToLastWindow();
    }

    public void closeAllOpenWindowExceptCurrent(){
        String currentWindow = driver.getWindowHandle();
        Set<String> windowList = driver.getWindowHandles();
        for(String x : windowList){
            if(!currentWindow.contentEquals(x)){ //If "x" is not the current window, then switch to window "x" and then close it
                driver.switchTo().window(x);
                driver.close();
            }
        }
        driver.switchTo().window(currentWindow); //Switch back to the first window
    }

}
