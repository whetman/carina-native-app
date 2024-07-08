package com.solvd.tests;

import com.solvd.components.Header;
import com.solvd.pages.common.HomePageBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.assertTrue;

public class OpenAppTest extends AbstractTest {

    @Test
    public void validateAppIsOpening() {
        SoftAssert sa = new SoftAssert();
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);

        homePage.isPageOpened();

        Header header = homePage.getHeader();
        assertTrue("Header is not displayed", header.isVisible());

        sa.assertAll();
    }
}
