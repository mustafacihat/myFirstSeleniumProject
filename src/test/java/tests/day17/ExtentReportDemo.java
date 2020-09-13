package tests.day17;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

public class ExtentReportDemo {

    //this class is used for starting and building reports
    ExtentReports report;
    //this class is used to create HTML report file
    ExtentHtmlReporter htmlReporter;
    //this will define a test, enables adding logs, aauthors, test steps
    ExtentTest extentLogger;


    @BeforeMethod
    public void setUp(){
        //initialize the class
        report = new ExtentReports();

        //create a report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath+"/test-output/report.html";
        //initialize the html reporter with the report path
        htmlReporter= new ExtentHtmlReporter(path);

        //attach the html report to report object
        report.attachReporter(htmlReporter);

        //title in the report
        htmlReporter.config().setReportName("Vytrack Smoke Test");

        //set environment information
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("Tester","Cybertek Testers");

    }

    @Test
    public void test1(){
        //give name to current test
        extentLogger = report.createTest("TC123 Login as a Driver");

        //test steps
        //info --> write test steps

        extentLogger.info("Open Chrome");

        extentLogger.info("go to url");

        extentLogger.info("enter driver username and password");

        extentLogger.info("click submit");

        extentLogger.info("verify logged in");

        //pass --marks the test case passed
        extentLogger.info("TC123 is passed");

        extentLogger.pass("TC 129 test is passed");


    }

    @AfterMethod
    public void tearDown(){
        //this is when the report is actuall created
        report.flush();
    }



}
