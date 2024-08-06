package com.solvd.tests.demoapp;

import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.solvd.tests.AbstractTest;
import org.testng.annotations.Test;

public class OpenAppTest extends AbstractTest {

    @Test
    public void validateAppIsOpening() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        catalogPage.isPageOpened();
    }
}
