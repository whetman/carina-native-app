package com.solvd.tests.demoapp;

import com.solvd.demoapp.pages.common.CartPageBase;
import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.solvd.demoapp.pages.common.LoginPageBase;
import com.solvd.demoapp.pages.common.ProductPageBase;
import com.solvd.demoapp.pages.common.RightMenuPageBase;
import com.solvd.demoapp.pages.components.bottommenu.BottomMenu;
import com.solvd.tests.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MyDemoAppTest extends AbstractTest {

    @Test(testName = "#TC0001", description = "Validate that user can log in")
    public void validateLogging(){
        //preconditions - user is logged - logging doesn't work on this app because of the broken keyboard feature!
        //it also doesn't work while buying!
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        BottomMenu bottomMenu = catalogPage.getBottomMenu();
        RightMenuPageBase rightMenuPageBase = bottomMenu.clickMoreButton();
        LoginPageBase loginPage1 = rightMenuPageBase.goToLoginPage();
        loginPage1.isPageOpened();
        loginPage1.logIn(R.TESTDATA.get("username-demo"), R.TESTDATA.get("password-demo"));
    }

    @Test(testName = "#TC0002", description = "Validate that not logged user can add product to the cart and delete it")
    public void validateAddingToCart(){
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        ProductPageBase productPage = catalogPage.addRandomProductToCart();
        CartPageBase cartPage = productPage.addDefaultToCartAndGoToCart();
        boolean removed = cartPage.removeRandomItemFromCart();
        assertTrue(removed, "Item was not removed successfully");
    }

}
