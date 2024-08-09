package com.solvd.tests.demoapp.android;

import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.solvd.demoapp.pages.common.LoginPageBase;
import com.solvd.demoapp.pages.common.MenuPageBase;
import com.solvd.tests.demoapp.AbstractTest;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MyDemoAppAndroidTest extends AbstractTest {

    @TestCaseKey("ANDT-56")
    @Test(description = "Validate that user can log in")
    public void validateLogging() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        MenuPageBase menuPage = catalogPage.getHeader().openMenu();
        LoginPageBase loginPage = menuPage.goToLoginPage();
        CatalogPageBase catalogPageLogged = loginPage.loginBob();
        takeScreenshot();
        boolean pageOpened = catalogPageLogged.isPageOpened();
        assertTrue(pageOpened, "Logging in failed!");
    }
}
