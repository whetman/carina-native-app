package com.solvd.tests.pandora;

import com.solvd.pandora.pages.common.AddressBookBase;
import com.solvd.pandora.pages.common.HomePageBase;
import com.solvd.pandora.pages.common.MyAccountPageBase;
import com.solvd.pandora.pages.common.WelcomePageBase;
import com.solvd.tests.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AppFeaturesTests extends AbstractTest {


    //in progress!
    @Test(testName = "#TC0001")
    public void validateAddressBook() throws InterruptedException {
        SoftAssert sa = new SoftAssert();
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);

        homePage.isPageOpened();

        MyAccountPageBase myAccountPage = homePage.getHeader().clickLoginButton();
        WelcomePageBase welcomePage = myAccountPage.login(R.TESTDATA.get("email"), R.TESTDATA.get("password"));

        welcomePage.isPageOpened();

        AddressBookBase addressBook = welcomePage.getHeader().openAddressBook();
        addressBook.isPageOpened();


    }
}
