package com.solvd.tests.demoapp;

import com.solvd.demoapp.pages.common.CatalogPageBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class OpenAppTest extends AbstractTest {

    @Test
    public void validateAppIsOpening() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        boolean pageOpened = catalogPage.isPageOpened();
        assertTrue(pageOpened, "Page was not opened!");
    }
}
