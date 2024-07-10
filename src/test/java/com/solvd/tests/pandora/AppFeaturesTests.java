package com.solvd.tests.pandora;

import com.solvd.pandora.pages.common.HomePageBase;
import com.solvd.pandora.pages.common.MyAccountPageBase;
import com.solvd.tests.AbstractTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AppFeaturesTests extends AbstractTest {


    //in progress!
    @Test(testName = "#TC0001")
    public void validateAddressBook() {
        SoftAssert sa = new SoftAssert();
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);

        homePage.isPageOpened();
//"kojanwalski1990@gmail.com", "K0w4l4k1!"
        MyAccountPageBase myAccountPageBase = homePage.getHeader().clickLoginButton();
        myAccountPageBase.login("kojanwalski1990@gmail.com", "K0w4l4k1!");

    }
}
