package com.solvd.tests.demoapp.ios;

import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.solvd.demoapp.pages.common.LoginPageBase;
import com.solvd.demoapp.pages.common.MenuPageBase;
import com.solvd.tests.AbstractTest;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MyDemoAppIOSTest extends AbstractTest {

    @TestCaseKey("ANDT-13")
    @Test(description = "Validate that user can log in")
    public void validateLogging() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        MenuPageBase MenuPage = catalogPage.clickMoreButton();
        LoginPageBase loginPage = MenuPage.goToLoginPage();
        takeScreenshot();
        CatalogPageBase catalogPageLogged = loginPage.loginBob();
        boolean pageOpened = catalogPageLogged.isPageOpened();
        assertTrue(pageOpened, "Successfully redirected after logging in");
        MenuPageBase rightMenuPageLogged = catalogPageLogged.clickMoreButton();
        boolean visible = rightMenuPageLogged.getLogoutButton().isVisible(0);
        takeScreenshot();
        assertTrue(visible, "Logout button is not displayed - user not logged!");
    }
}
