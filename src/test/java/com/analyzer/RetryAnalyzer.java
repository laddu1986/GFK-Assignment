package com.analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created by Laddu shashavali
 */
public class RetryAnalyzer implements IRetryAnalyzer {

    int count = 0;
    int retry = 1;

    // As of now, just want to retry my failed test cases only once.
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(count<retry){
            count++;
            return true;
        }
        return false;
    }

}
