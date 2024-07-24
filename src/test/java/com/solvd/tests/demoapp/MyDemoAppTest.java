package com.solvd.tests.demoapp;

import com.solvd.demoapp.constants.Colors;
import com.solvd.demoapp.pages.common.CartPageBase;
import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.solvd.demoapp.pages.common.LoginPageBase;
import com.solvd.demoapp.pages.common.ProductPageBase;
import com.solvd.demoapp.pages.common.RightMenuPageBase;
import com.solvd.tests.AbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MyDemoAppTest extends AbstractTest {

    @Test(testName = "#TC0001", description = "Validate that user can log in")
    public void validateLogging() {
        //preconditions - user is logged - logging doesn't work on this app because of the broken keyboard feature!
        //it also doesn't work while buying!
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        RightMenuPageBase rightMenuPageBase = catalogPage.clickMoreButton();
        LoginPageBase loginPage = rightMenuPageBase.goToLoginPage();
        loginPage.isPageOpened();
        loginPage.logIn(R.TESTDATA.get("username-demo"), R.TESTDATA.get("password-demo"));
    }

    @Test(testName = "#TC0002", description = "Validate that not logged user can add product to the cart and delete it")
    public void validateAddingToCart() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        ProductPageBase productPage = catalogPage.addRandomProductToCart();
        CartPageBase cartPage = productPage.addToCartAndGoToCart();
        boolean removed = cartPage.removeRandomItemFromCart();
        assertTrue(removed, "Item was not removed successfully");
    }

    @Test(testName = "#TC0003", description = "Validate that not logged user can rate product both on the catalog and on the product page")
    public void validateRating() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        ExtendedWebElement okButtonCatalog = catalogPage.rateRandomProduct();
        assertTrue(okButtonCatalog.isDisplayed(), "OK button on catalog page is not displayed");
        okButtonCatalog.click();
        ProductPageBase productPage = catalogPage.clickRandomProduct();
        ExtendedWebElement okButtonProduct = productPage.rateProduct();
        assertTrue(okButtonProduct.isDisplayed(), "OK button on product page is not displayed");
        okButtonProduct.click();
    }

    //todo in progress
    @Test(testName = "#TC0004", description = "Validate that not logged user can add multiple products with different colors/sizes to the cart and delete some of them from the cart")
    public void validateChangingProductProperties() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        ProductPageBase productPage = catalogPage.clickRandomProduct();
        boolean isColorChanged = productPage.selectColor(Colors.BLUE);
        assertTrue(isColorChanged, "Color was not changed successfully");
        boolean isQuantityChangedPlus = productPage.changeQuantityAdd();
        assertTrue(isQuantityChangedPlus, "Quantity was not added successfully");
        boolean isQuantityChangedMinus = productPage.changeQuantityRemove();
        assertTrue(isQuantityChangedMinus, "Quantity was not removed successfully");
        String valueOnProductPage = productPage.getQuantity().getAmount().getAttribute("value");
        CartPageBase cartPage = productPage.addToCartAndGoToCart();

        //check quantity before adding to cart and if in cart is the same
    }

}
