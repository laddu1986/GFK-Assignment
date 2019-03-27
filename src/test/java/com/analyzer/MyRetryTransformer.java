package com.analyzer;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by Laddu shashavali
 *
 * This class is used to implement the Retry Analyzer with a "testng.xml" file instead of using it with
 * every @Test annotation. This annotation saves time from copy-pasting the "RetryAnalyzer.class" in
 * every @Test annotation in my classes. However, for this project, I have used the basic approach,
 * i.e. to use the "RetryAnalyzer.class" in @Test because it is a Cucumber based project and hence the
 * Runner file has only one @Test annotation.
 *
 * P.S: This process of calling the Retry Analyzer only once through the xml file is based upon the
 * Reflection API of java... which pretty much looks for failed tests at runtime.
 */

public class MyRetryTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        iTestAnnotation.setRetryAnalyzer(RetryAnalyzer.class);
    }

}
