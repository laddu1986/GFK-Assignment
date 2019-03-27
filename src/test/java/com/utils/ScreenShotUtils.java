package com.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by Laddu shashavali
 */
public class ScreenShotUtils extends UtilsController {

    public ScreenShotUtils(WebDriver driver) {
        super(driver);
    }

    //Method to capture ScreenShot
    public String captureScreenShot(WebDriver driver, String screenshotName){
        String destinationPath=System.getProperty("user.dir") + "\\output\\screenshots\\" + screenshotName + ".png";
        try {
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destinationFile = new File(destinationPath);
            // Files.copy(sourcePath, destinationPath);
            String imagePath = destinationFile.getCanonicalPath();
            System.out.println("Image path is: " + imagePath);
           /* if (!destinationFile.exists()) {
                FileUtils.touch(destinationFile);
            }*/
            FileUtils.copyFile(sourceFile, destinationFile);
            System.out.println("ScreenShot taken...at: "+destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destinationPath;
    }

}
