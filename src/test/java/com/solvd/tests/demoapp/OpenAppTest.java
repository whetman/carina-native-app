package com.solvd.tests.demoapp;

import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.solvd.tests.AbstractTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OpenAppTest extends AbstractTest {

    @Test
    public void validateAppIsOpening() {
        SoftAssert sa = new SoftAssert();
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);

        catalogPage.isPageOpened();

        sa.assertAll();
    }
}
