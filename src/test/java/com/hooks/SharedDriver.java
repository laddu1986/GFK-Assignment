
package com.hooks;

import com.cucumber.listener.Reporter;
/*import com.utils.DriverFactory;*/
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.utils.extra_utils.Constant.*;
import static org.openqa.selenium.ie.InternetExplorerDriver.IGNORE_ZOOM_SETTING;

/**
 * <p>
 * Example of a WebDriver implementation that has delegates all methods to a static instance (REAL_DRIVER) that is only
 * created once for the duration of the JVM. The REAL_DRIVER is automatically closed when the JVM exits. This makes
 * scenarios a lot faster since opening and closing a browser for each scenario is pretty slow.
 * To prevent browser state from leaking between scenarios, cookies are automatically deleted before every scenario.
 * </p>
 * <p>
 * A new instance of SharedDriver is created for each Scenario and passed to yor Stepdef classes via Dependency Injection
 * </p>
 * <p>
 * As a bonus, screenshots are embedded into the report for each scenario. (This only works
 * if you're also using the HTML formatter).
 * </p>
 * <p>
 * A new instance of the SharedDriver is created for each Scenario and then passed to the Step Definition classes'
 * constructor. They all receive a reference to the same instance. However, the REAL_DRIVER is the same instance throughout
 * the life of the JVM.
 * </p>
 */
public class SharedDriver extends EventFiringWebDriver {
    protected static final WebDriver REAL_DRIVER;
    final Logger logger = LoggerFactory.getLogger(SharedDriver.class);
    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            REAL_DRIVER.close();

        }
    };
    private static Properties properties;
    static {
        loadProperties();
        String browser = properties.getProperty("browser");
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
        try {
            REAL_DRIVER = getBrowser(browser);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new Error(throwable);
        }
    }

    public SharedDriver() {
        super(REAL_DRIVER);
        REAL_DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Override
    public void close() {
        if (Thread.currentThread() != CLOSE_THREAD) {
            throw new UnsupportedOperationException("You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
        }
        super.close();
    }

/**
 * Creating a driver instance
 */

    public static WebDriver getBrowser(String desiredBrowserName) throws Throwable {
       // String desiredBrowserName = System.getProperty("browser", "chrome");
        WebDriver desiredBrowser = null;
        DesiredCapabilities capabilities =null;
        switch(desiredBrowserName) {
            case "ie":
                capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(IGNORE_ZOOM_SETTING, true);
                System.setProperty("webdriver.ie.driver", IE_DRIVER_DIRECTORY);
                desiredBrowser = new InternetExplorerDriver(capabilities);
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver",CHROME_DRIVER_DIRECTORY);// "src/test/resources/drivers/chromedriver_Win.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-infobars");
                options.addArguments("--start-maximized");
                desiredBrowser = new ChromeDriver(options);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver",GECKO_DRIVER_DIRECTORY);// "src/test/resources/drivers/geckodriver_Win.exe");
                capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("marionette", true);
                ProfilesIni prof = new ProfilesIni();
                FirefoxProfile ffProfile = prof.getProfile("default");
                ffProfile.setAcceptUntrustedCertificates(true);
                ffProfile.setAssumeUntrustedCertificateIssuer(false);
                desiredBrowser = new FirefoxDriver((Capabilities) ffProfile);
                break;
            default:
                //work out what to do when a browser isn't needed
                break;
        }
        return desiredBrowser;
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
                FileInputStream fs = new FileInputStream(CONFIG_PROPERTIES_DIRECTORY);
                properties.load(fs);
            } catch (Exception e) {
                e.printStackTrace();
                // report
            }
        }
    }
}

