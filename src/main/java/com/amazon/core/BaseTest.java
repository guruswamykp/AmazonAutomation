package com.amazon.core;

import com.amazon.core.utils.TestListener;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseTest extends TestListener {
    public WebDriver driver;
    public Map<String,String> testData;
    public static String qtestid;

    public BaseTest(){

    }

    public WebDriver getDriver() {
        return this.driver;
    }

    /**
     * create devTools session
     */
    public DevTools createDevToolSession(){
        DevTools chromeDevTools = ((ChromeDriver) driver).getDevTools();

        //chromeDevTools.createSession();
        return chromeDevTools;
    }

    /**
     * initialize the browser
     */
    public void initializeBrowser(){
        driver = new ChromeDriver();
        //set sindow size based on the requirement ex: ddot, mdot, tdot
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * navigate to appropriate application
     */
    public void navigateToApplication() throws InterruptedException {
        //here we can handle qa url's
        driver.get("https://www.amazon.in/");
        if(driver.findElement(By.xpath("//a[@aria-label='Amazon.in']")).isDisplayed())
            logger.info("Application landed");
        else
            Assert.fail("home page is not displayed");
    }

    public static void getTestDescription(String description){
        qtestid = description;
        logger.info("Test Started For:"+qtestid);
    }

    //@DataProvider(name = "testData")
    public Map<String,String> getTestDataFromExcel() throws IOException {
        testData = new HashMap<>();
        try {

            String cellValue = null;
            int requiredRow = 0;

            FileInputStream fis = new FileInputStream("./testData.xlsx");
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet("Sheet1");

            int lastRowNumber = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();

            List<String> rowHeader = new ArrayList<>();
            for (int i=0; i<colCount; i++){
                Row row = sheet.getRow(0);
                String header = row.getCell(i).getStringCellValue().trim();
                rowHeader.add(header);
            }

            for (int i=1;i<lastRowNumber;i++) {
                Row row = sheet.getRow(i);
                String excelQtestId = row.getCell(0).getStringCellValue();
                if (qtestid.equalsIgnoreCase(excelQtestId)) {
                    requiredRow = i;
                }
            }

            for (int j = 0; j < colCount; j++) {
                Row row = sheet.getRow(requiredRow);
                Cell cell = row.getCell(j);
                cellValue = cell.getStringCellValue().trim();
                testData.put(rowHeader.get(j),cellValue);
            }

            workbook.close();
            fis.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return testData;
    }

    /**
     * finaly block used to handle closuer methods
     */
    public void finallyBlock(){
        driver.quit();
    }



}

