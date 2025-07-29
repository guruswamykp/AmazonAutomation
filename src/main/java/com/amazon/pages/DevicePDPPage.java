package com.amazon.pages;

import com.amazon.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class DevicePDPPage extends BasePage {
    private final WebDriver driver;
    Map<String,String> testData;

    private static final By BUY_NOW = By.xpath("//input[@id='buy-now-button']");

    public DevicePDPPage(WebDriver driver, Map<String,String> testData) {
        super(driver);
        this.driver = driver;
        this.testData = testData;
    }

    public void selectDevice(){
        //Device configuration
        clickOnElement(BUY_NOW);

    }

    public void selectDeviceColor(){

    }
    public void selectDeviceStorage(){

    }

}
