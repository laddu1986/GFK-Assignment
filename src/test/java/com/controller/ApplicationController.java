package com.controller;

import org.openqa.selenium.WebDriver;

/**
 * Created by Laddu shashavali
 */
public class ApplicationController {
    protected WebDriver driver = null;

    public ApplicationController(){
    }

    public ApplicationController(WebDriver driver) {
        this.driver = driver;
    }

    private AutomationPracticePageController automationPracticePage = null;
    private APIServiceController apiService = null;


    public AutomationPracticePageController automationPractice(){
        if(automationPracticePage == null){
            automationPracticePage = new AutomationPracticePageController(driver);
        }
        return automationPracticePage;
    }

    public APIServiceController apiservice(){
        if(apiService == null){
            apiService = new APIServiceController();
        }
        return apiService;
    }

}
