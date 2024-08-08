package com.solvd.tests.demoapp.android;

import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.solvd.demoapp.pages.common.LoginPageBase;
import com.solvd.demoapp.pages.common.MenuPageBase;
import com.solvd.tests.AbstractTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MyDemoAppAndroidTest extends AbstractTest {

    @Test(testName = "ANDT-13", description = "Validate that user can log in")
    public void validateLogging() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        MenuPageBase menuPage = catalogPage.getHeader().openMenu();
        LoginPageBase loginPage = menuPage.goToLoginPage();
        CatalogPageBase catalogPageLogged = loginPage.loginBob();
        boolean pageOpened = catalogPageLogged.isPageOpened();
        assertTrue(pageOpened, "Logging in failed!");
    }
}
