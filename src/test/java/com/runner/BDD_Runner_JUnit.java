package com.runner;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


/**
 * To run it from the Command Line Interface, the following codes/syntax are used.
 * mvn clean test -Dcucumber.options="--tags @debug"                   //Only debug
 * mvn clean test -Dcucumber.options="--tags @debug --tags @smoke"     //AND
 * mvn clean test -Dcucumber.options="--tags @debug,@smoke"            //OR
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = { "@api,@web"},
        monochrome = true,
        features = {
                "src/test/resources/features",
                "src/test/resources/features",
        },
        glue = {
                "com.steps",
                "com.hooks"
        },
        plugin = {
                "pretty:target/cucumber-test-report/cucumber-pretty.txt",
                "html:target/cucumber-test-report",
                "json:target/cucumber-test-report/cucumber-report.json",
                "rerun:target/rerun.txt",
                "junit:target/cucumber-test-report/test-report.xml"
                // ----------- For Individual Page Reports ----------- //
                ,"com.cucumber.listener.ExtentCucumberFormatter:"//target/extent-reports/addToCart_report.html"
                }
)
public class BDD_Runner_JUnit {
        @BeforeClass
        public static void beforeClass(){
                //Do things
                ExtentProperties extentProperties = ExtentProperties.INSTANCE;
                extentProperties.setReportPath("output/TestReport.html");
        }
        @AfterClass
        public static void afterClass(){
              Reporter.getExtentHtmlReport().setAppendExisting(true);
        }
}
