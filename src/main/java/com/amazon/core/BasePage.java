package com.amazon.core;

import com.amazon.core.utils.ExtentReporting;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasePage extends ExtentReporting {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;

    }

    /**
     * click on element
     */
    public void clickOnElement(By element){
        driver.findElement(element).click();
        logger.info("Element "+element+" is clicked succesfuly");
    }

    /**
     * check is element is present
     */
    public boolean isElementPresent(By element){
        boolean present;
        try{
            driver.findElement(element);
            present = true;
            logger.info("Element "+element+" is present");
        }catch (NoSuchElementException e){
            logger.info("Element "+element+" is not present");
            present = false;
        }
        return present;
    }

    /**
     * enter text in element
     */
    public void enterText(By element,String text){
        WebElement ele = driver.findElement(element);
        ele.clear();
        ele.sendKeys(text);
        logger.info("Text "+text+" entered in "+element+" successfully");
    }

    /**
     * Navigate to child window
     */
    public void navigateToChildWindow(){
        String parentWindow = driver.getWindowHandle();
        driver.getWindowHandles().forEach(handle->{
            if(!handle.equals(parentWindow)){
                driver.switchTo().window(handle);
                logger.info("Switched to child window");
            }
        });
    }

    /**
     * capture screenshot of the page
     */
    public String captureScreenshot(String pageName) throws IOException{

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddmmyyyy_HHmmss");
        String timestamp = formatter.format(date);

        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        String Path = System.getProperty("user.dir")+"/screenshots/"+pageName+"_"+timestamp+".png";
        File destination = new File(Path);
        try {
            FileHandler.copy(screenshot, destination);
            logger.info("Screenshot captured for "+pageName);
        } catch (IOException e) {
            logger.error("Failed to capture screenshot for "+pageName);
            throw e;
        }

        return Path;
    } 




}
