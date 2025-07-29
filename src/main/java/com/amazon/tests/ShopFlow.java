package com.amazon.tests;

import com.amazon.core.BaseTest;
import com.amazon.core.utils.TestListener;
import com.amazon.pages.AmazonHomePage;
import com.amazon.pages.DevicePDPPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class ShopFlow extends BaseTest {

    private AmazonHomePage amazonHomePage;
    private DevicePDPPage devicePDPPage;


    @Test(description = "tc1")
    public void sample() {
        try{
            initializeBrowser();
            initializePageObjects();
            getTestDataFromExcel();
            navigateToApplication();
            System.out.println(testData.get("collection"));
            System.out.println(testData.get("username"));
            System.out.println(testData.get("qtestid"));
           /* amazonHomePage.navigateToMobiles();
            amazonHomePage.selectItemBySearchIcon();
            devicePDPPage.selectDevice();*/


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            finallyBlock();
        }
    }

    @Test(description = "tc2",groups = {"smoke"})
    public void sample2() {
        try{
            initializeBrowser();
            initializePageObjects();
            getTestDataFromExcel();
            navigateToApplication();
            System.out.println(testData.get("collection"));
            System.out.println(testData.get("username"));
            System.out.println(testData.get("qtestid"));
           /* amazonHomePage.navigateToMobiles();
            amazonHomePage.selectItemBySearchIcon();
            devicePDPPage.selectDevice();*/
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            finallyBlock();
        }
    }

    @Test(description = "tc3",groups = {"smoke"})
    public void sample3() {
        try{
            initializeBrowser();
            initializePageObjects();
            getTestDataFromExcel();
            navigateToApplication();
            /*System.out.println(testData.get("collection"));
            System.out.println(testData.get("username"));
            System.out.println(testData.get("qtestid"));*/
           /* amazonHomePage.navigateToMobiles();
            amazonHomePage.selectItemBySearchIcon();
            devicePDPPage.selectDevice();*/

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            finallyBlock();
        }
    }

    void initializePageObjects(){
        amazonHomePage = new AmazonHomePage(getDriver(),testData);
        devicePDPPage = new DevicePDPPage(getDriver(),testData);
    }
}
