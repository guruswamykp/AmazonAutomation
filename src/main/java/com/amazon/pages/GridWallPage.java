package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.amazon.core.BasePage;

import java.util.Map;

public class GridWallPage extends BasePage{
    private final WebDriver driver;
    Map<String,String> testData;

    private static final By MOBILES = By.xpath("//a[text()='Mobiles']");
    private static final By Search_Results = By.xpath("//a[@target='_blank']//h2");
    

    public GridWallPage(WebDriver driver, Map<String,String> testData) {
        super(driver);
        this.driver = driver;
        this.testData = testData;

    }

    /**
     * Select a First device from search results
     */
    public void selectDevicefromSearchResults(String searchItem){
        By item = By.xpath("(//div[@data-component-type='s-search-result']//*[contains(@aria-label,'"+searchItem+"')])[1]");
        driver.findElement(item).click();

        navigateToChildWindow();
    }

    /**
     * Get all search results
     */
    public void getAllSearchResults(){
        driver.findElements(Search_Results).forEach(result->{
            logger.info(result.getText());
        });
    }








}
