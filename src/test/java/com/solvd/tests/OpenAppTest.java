package com.solvd.tests;

import com.solvd.pages.common.HomePageBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.assertTrue;

public class OpenAppTest extends AbstractTest {

    //still in progress!
    @Test
    public void validateAppIsOpening() throws InterruptedException {
        SoftAssert sa = new SoftAssert();
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);

        homePage.isPageOpened();

        boolean displayed = homePage.getIconLogo().isDisplayed();
        assertTrue("Icon logo is not displayed", displayed);

        sa.assertAll();
    }
}
