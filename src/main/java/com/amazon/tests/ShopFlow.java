package com.amazon.tests;

import com.amazon.core.BaseTest;
import com.amazon.core.utils.TestListener;
import com.amazon.pages.AmazonHomePage;
import com.amazon.pages.DevicePDPPage;
import com.amazon.pages.GridWallPage;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class ShopFlow extends BaseTest {

    private AmazonHomePage amazonHomePage;
    private DevicePDPPage devicePDPPage;
    private GridWallPage gridWallPage;

    /**
     * Select a device by search icon
     */
    @Test(description = "tc1")
    public void selectDeviceBySearchIcon() {
        try{
            initializeBrowser();
            initializePageObjects();
            getTestDataFromExcel();
            navigateToApplication();
            // checkk excel data is fetching or not 
            logger.info(testData.get("collection"));
            logger.info(testData.get("username"));
            logger.info(testData.get("qtestid"));
            amazonHomePage.navigateToMobiles();
            amazonHomePage.selectItemBySearchIcon("Apple iPhone 17 Pro");

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            finallyBlock();
        }
    }

    /**
     * Get all search results
     */
    @Test(description = "tc2",groups = {"smoke"})
    public void getAllSearchResults() {
        try{
            initializeBrowser();
            initializePageObjects();
            getTestDataFromExcel();
            navigateToApplication();
            amazonHomePage.navigateToMobiles();
            amazonHomePage.selectItemBySearchIcon("Apple iPhone 17 Pro");
            gridWallPage.getAllSearchResults();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            finallyBlock();
        }
    }

    /**
     * Select a device to buy
     */
    @Test(description = "tc3",groups = {"smoke"})
    public void selectMobileToBuy() {
        try{
            initializeBrowser();
            initializePageObjects();
            getTestDataFromExcel();
            navigateToApplication();
            amazonHomePage.navigateToMobiles();
            amazonHomePage.selectItemBySearchIcon("Apple iPhone 17 Pro");
            gridWallPage.selectDevicefromSearchResults("Apple iPhone 17 Pro");
            devicePDPPage.selectDeviceToBuy();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            finallyBlock();
        }
    }



    void initializePageObjects(){
        amazonHomePage = new AmazonHomePage(getDriver(),testData);
        devicePDPPage = new DevicePDPPage(getDriver(),testData);
        gridWallPage = new GridWallPage(getDriver(),testData);
    }
}
