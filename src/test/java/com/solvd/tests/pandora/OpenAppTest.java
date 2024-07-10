package com.solvd.tests.pandora;

import com.solvd.pandora.components.android.Header;
import com.solvd.pandora.pages.common.HomePageBase;
import com.solvd.tests.AbstractTest;
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
