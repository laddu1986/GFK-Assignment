package com.hooks;

import com.Logger;
import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Laddu shashavali
 */


public class BeforeAfterHook extends BaseSteps {
    Logger logger =new Logger(BeforeAfterHook.class);
    @Before
    public void setUp(Scenario scenario) {
        if (!scenario.getSourceTagNames().contains("api")) {
            if (REAL_DRIVER instanceof ChromeDriver) {
                REAL_DRIVER.manage().window().maximize();
            }
            REAL_DRIVER.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            REAL_DRIVER.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
            REAL_DRIVER.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"/src/test/resources/extent-config.xml"));
            Reporter.setSystemInfo("User Name",System.getProperty("user.name"));
            Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
            Reporter.setSystemInfo("64 Bit", "Windows 8.1");
            Reporter.setSystemInfo("3.8.1", "Selenium");
            Reporter.setSystemInfo("3.5", "Maven");
            Reporter.setSystemInfo("1.8.0", "Java Version");
            Reporter.setTestRunnerOutput("Cucumber TestNg Runner");
            Reporter.assignAuthor("Laddu Shashavali");
            //For Extent Reports
            logger.writeLog("INFO","----------------------------------------------------------------------");
            logger.writeLog("INFO","*************** Test Environment Set up ***************");
            logger.writeLog("INFO","***************    Starting Scenario    ***************");
            logger.writeLog("INFO","*************** Scenario Name -- " + scenario.getName() + " ***************");
            logger.writeLog("INFO","----------------------------------------------------------------------");
        }
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                logger.writeLog("INFO","Inside after method...at: " );
                WebDriver augmentedDriver = new Augmenter().augment(REAL_DRIVER);
               // File source = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
                TakesScreenshot tss=(TakesScreenshot) augmentedDriver;
                String screenshotName = scenario.getName().replaceAll(" ", "_");
                String destinationPath = System.getProperty("user.dir") + "\\output\\screenshots\\" + screenshotName + ".png";
                logger.writeLog("INFO","Image path is.......at: "+ destinationPath);
                File sourceFile = tss.getScreenshotAs(OutputType.FILE);
                File destinationFile = new File(destinationPath);
                FileUtils.copyFile(sourceFile, destinationFile);
                scenario.embed(((TakesScreenshot) REAL_DRIVER).getScreenshotAs(OutputType.BYTES), "image/png");
                logger.writeLog("INFO","ScreenShot taken...at: " + destinationPath);
                Reporter.addStepLog("<a href='file:///" + destinationPath + "'> Screenshot : " + screenshotName + "</a>");
                Reporter.addScreenCaptureFromPath(destinationPath);
                // For screenshot in extent cucumber report
                // For screenshot in basic cucumber report
                //SendEmailUtils.emailReport("shasha.intell@gmail.com", "Failed Test Report For " + scenario.getName(), "Scenario ID : " + scenario.getId() + " -- FAILED..!! ");
            } catch (IOException e) {
                logger.writeLog("INFO","Error in taking the screenshot");

            }
        }
        logger.writeLog("INFO","Test Environment Destroyed");
        logger.writeLog("INFO","----------------------------------------------------------------------");
    }

}
