package com.amazon.core.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.amazon.core.BasePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporting implements ITestListener {
    public static final Logger logger = LogManager.getLogger(TestListener.class);
    
    ExtentSparkReporter sparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result) {

      Date date = new Date();
      SimpleDateFormat formatter = new SimpleDateFormat("ddmmyyyy_HHmmss");
      String timestamp = formatter.format(date); 

      sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/extent-reports/extent-report" + timestamp + ".html");
      extentReports = new ExtentReports();
      extentReports.attachReporter(sparkReporter);



   }

   @Override
   public void onTestSuccess(ITestResult result) {
      extentTest.pass("Test passed");
   
   }
   
   @Override
      public void onTestFailure(ITestResult result) {
      extentTest.fail("Test failed");
   }

        

   /**
   * capture screenshot for extent report
   */
   public void captureScreenshotForExtentReport(String pageName) throws IOException{
      extentTest = extentReports.createTest(pageName);
      try{
         String path = new BasePage(driver).captureScreenshot(pageName);
         extentTest.addScreenCaptureFromPath(path);
      } catch(IOException e){
         //logger.error("Failed to capture screenshot for extent report for "+pageName);
         throw e;
      }
   }

   @Override
   public void onTestSkipped(ITestResult result) {
      extentTest.skip("Test skipped");
   }

   @Override
   public void onFinish(ITestContext result) {
      extentReports.flush();
   }



}
