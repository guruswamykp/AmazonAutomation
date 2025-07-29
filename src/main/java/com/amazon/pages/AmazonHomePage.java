package com.amazon.pages;

import com.amazon.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;


public class AmazonHomePage extends BasePage {
    private final WebDriver driver;
    Map<String,String> testData;
    private static final By MOBILES = By.xpath("//a[text()='Mobiles']");
    private static final By SEARCH_TEXTBOX = By.xpath("//input[@id='twotabsearchtextbox']");
    private static final By SEARCHICON = By.xpath("//input[@id='nav-search-submit-button']");



    public AmazonHomePage(WebDriver driver, Map<String,String>testData) {
        super(driver);
        this.driver = driver;
         this.testData = testData;
        //init(driver);
    }

    /**
     * navigate to mobiles tab
     */
    public void navigateToMobiles() throws InterruptedException {
        Thread.sleep(5000);
        clickOnElement(MOBILES);

        Thread.sleep(5000);

    }

    /**
     * select item by search box
     */
    public void selectItemBySearchIcon() throws InterruptedException {
        clickOnElement(SEARCH_TEXTBOX);
        String searchItem = "Apple iPhone 15";
        enterText(SEARCH_TEXTBOX,searchItem);

        driver.findElement(SEARCHICON).click();
        By item = By.xpath("(//div[@data-component-type='s-search-result']//*[contains(@aria-label,'"+searchItem+"')])[1]");
        driver.findElement(item).click();
    }


}
