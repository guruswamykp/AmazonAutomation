package com.amazon.core.utils;

import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporting implements ITestListener {
    
    ExtentSparkReporter sparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;
  


     public void createTest(String testName){
        // code to create test in extent report
     }

     public void logInfo(String message){
        // code to log info in extent report
     }

     public void logPass(String message){
        // code to log pass in extent report
     }

     public void logFail(String message){
        // code to log fail in extent report
     }

}
