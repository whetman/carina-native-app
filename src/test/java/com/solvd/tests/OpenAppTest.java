package com.solvd.tests;

import com.solvd.pages.common.HomePageBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OpenAppTest extends AbstractTest{

    //still in progress!
    @Test
    public void validateAppIsOpening() throws InterruptedException {
        SoftAssert sa = new SoftAssert();
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
//        boolean pageOpened = homePage.isPageOpened();
//        sa.assertTrue(pageOpened, "Page is not opened"); //working assertion
//        Thread.sleep(5000);
//        boolean displayed = homePage.getAgreementMessage().isDisplayed();
//        sa.assertTrue(displayed, "Message is not displayed");
//        AgreementWindow agreementWindow = homePage.getAgreementWindow();
//        boolean isAgreementWindowDisplayed = agreementWindow.isDisplayed();
//        sa.assertTrue(isAgreementWindowDisplayed, "Agreement window is not displayed");
//        boolean displayed = homePage.getAgreementButton().isDisplayed(); //stale element!
//        sa.assertTrue(displayed, "Button is not displayed");
//        if(displayed){
//            homePage.getAgreementButton().click();
//        }
        sa.assertAll();

    }
}
