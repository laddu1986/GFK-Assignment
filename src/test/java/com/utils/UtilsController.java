package com.utils;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Laddu shashavali
 */
public class UtilsController {

    protected WebDriver driver = null;
    public static final String UI_TEST_FULL_PATH = "//src//test//Resources//properties//UiTests.properties";
    /**
     * variable for properties
     */
    public static Properties properties;

    public UtilsController(WebDriver driver) {
        this.driver = driver;
    }

    public JavascriptUtils javascriptUtils(){
        return new JavascriptUtils(driver);
    }

     public void delay(int timeInMilli){
        try {
            Thread.sleep(timeInMilli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * load properties file
     *
     * @throws IOException
     */
    public static void loadProperties() {
        if (properties == null) {
            try {
                properties = new Properties();
                FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + UI_TEST_FULL_PATH);
                properties.load(fs);
            } catch (Exception e) {
                e.printStackTrace();
                // report
            }
        }
    }
}
