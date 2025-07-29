package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class GridWallPage {
    private final WebDriver driver;
    Map<String,String> testData;

    private static final By MOBILES = By.xpath("//a[text()='Mobiles']");

    public GridWallPage(WebDriver driver, Map<String,String> testData) {
        this.driver = driver;
        this.testData = testData;

    }

    public void selectDevice(){

    }






}
