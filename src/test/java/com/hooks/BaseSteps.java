package com.hooks;

import com.controller.ApplicationController;
/*import com.utils.DriverFactory;*/
import org.openqa.selenium.WebDriver;

/**
 * Created by Laddu shashavali
 */
public class BaseSteps extends SharedDriver{

    protected ApplicationController applicationController = null;

    public ApplicationController getAutomationPractice() {

        if (applicationController == null) {
            applicationController = new ApplicationController(REAL_DRIVER);
        }
        return applicationController;
    }



}
