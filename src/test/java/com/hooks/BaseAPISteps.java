package com.hooks;

import com.controller.ApplicationController;

/**
 * Created by Laddu shashavali
 */
public class BaseAPISteps {


    protected ApplicationController applicationController = null;

    public ApplicationController getAutomationPractice() {
        if (applicationController == null) {
            applicationController = new ApplicationController();
        }
        return applicationController;
    }



}
