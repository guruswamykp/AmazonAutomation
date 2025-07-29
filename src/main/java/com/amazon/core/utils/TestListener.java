package com.amazon.core.utils;

import com.amazon.core.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    public static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        String description = result.getMethod().getDescription();
        BaseTest.getTestDescription(description);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Passed!!!"+result.getMethod().getMethodName());
        logger.info("Description!!!"+result.getMethod().getDescription());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("Failed!!!"+result.getMethod().getMethodName());
        logger.info("Description!!!"+result.getMethod().getDescription());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("Skipped!!!"+result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Suite Started");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Suite Finish");
    }
}
