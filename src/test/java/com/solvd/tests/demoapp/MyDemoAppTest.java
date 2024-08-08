package com.solvd.tests.demoapp;

import com.solvd.demoapp.constants.Colors;
import com.solvd.demoapp.exception.ImageException;
import com.solvd.demoapp.pages.common.AboutPageBase;
import com.solvd.demoapp.pages.common.CartPageBase;
import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.solvd.demoapp.pages.common.DrawingPageBase;
import com.solvd.demoapp.pages.common.GeoLocationPageBase;
import com.solvd.demoapp.pages.common.LoginPageBase;
import com.solvd.demoapp.pages.common.MenuPageBase;
import com.solvd.demoapp.pages.common.ProductPageBase;
import com.solvd.demoapp.pages.common.SauceLabsBase;
import com.solvd.tests.AbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class MyDemoAppTest extends AbstractTest {

    @Test(testName = "#TC0001", description = "Validate that user can log in")
    public void validateLogging() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        MenuPageBase menuPage = catalogPage.clickMoreButton();
        LoginPageBase loginPage = menuPage.goToLoginPage();
        CatalogPageBase catalogPageLogged = loginPage.loginBob();
        boolean pageOpened = catalogPageLogged.isPageOpened();
        assertTrue(pageOpened, "Successfully redirected after logging in");
        MenuPageBase menuPageLooged = catalogPageLogged.clickMoreButton();
        boolean visible = menuPageLooged.getLogoutButton().isVisible(0);
        assertTrue(visible, "Logout button is not displayed - user not logged!");
    }

    @Test(testName = "#TC0002", description = "Validate that not logged user can add product to the cart and delete it")
    public void validateAddingToCart() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        ProductPageBase productPage = catalogPage.addRandomProductToCart();
        CartPageBase cartPage = productPage.addToCartAndGoToCart();

        boolean removed = cartPage.removeRandomItemFromCart();
        assertTrue(removed, "Item was not removed successfully");
    }

    @Test(testName = "#TC0003", description = "Validate that not logged user can rate product on the catalog")
    public void validateRatingCatalogPage() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        ExtendedWebElement okButtonCatalog = catalogPage.rateRandomProduct();

        assertTrue(okButtonCatalog.isDisplayed(), "OK button on catalog page is not displayed");
    }

    @Test(testName = "#TC0004", description = "Validate that not logged user can rate product on the product page")
    public void validateRatingProductPage() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        ProductPageBase productPage = catalogPage.clickRandomProduct();
        ExtendedWebElement okButtonProduct = productPage.rateProduct();

        assertTrue(okButtonProduct.isDisplayed(), "OK button on product page is not displayed");

        okButtonProduct.click();
    }

    @Test(testName = "#TC0005", description = "Validate that not logged user can add multiple products with different colors/sizes to the cart and delete them from the cart")
    public void validateChangingProductProperties() throws NoSuchFieldException, IllegalAccessException {
        SoftAssert softAssert = new SoftAssert();
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        ProductPageBase productPage = catalogPage.clickRandomProduct();

        boolean isColorChanged = productPage.selectColor(Colors.GRAY);
        softAssert.assertTrue(isColorChanged, "Color was not changed successfully. Something went wrong or chosen color not available");

        boolean isQuantityChangedPlus = productPage.changeQuantityAdd();
        softAssert.assertTrue(isQuantityChangedPlus, "Quantity was not added successfully");

        boolean isQuantityChangedMinus = productPage.changeQuantityRemove();
        softAssert.assertTrue(isQuantityChangedMinus, "Quantity was not removed successfully");

        String valueOnProductPage = productPage.getQuantity().getAmount().getAttribute("value");
        CartPageBase cartPage = productPage.addToCartAndGoToCart();

        String valueInTheCart = cartPage.getValue();
        boolean isQuantityTheSame = valueInTheCart.equals(valueOnProductPage);
        softAssert.assertTrue(isQuantityTheSame, "Quantity is not the same");

        boolean isRemoved = cartPage.removeItemsWithMinusButton(valueOnProductPage);
        softAssert.assertTrue(isRemoved, "Items were not removed successfully");
        softAssert.assertAll();

        boolean isGoShoppingVisible = cartPage.isGoShoppingButtonVisible();
        assertTrue(isGoShoppingVisible, "Go shopping button is not visible");
    }

    /**
     * Sorting by price doesn't work properly on the app - it is not sorting products by price, just changing the order of them, so I am not covering it in this test.
     */
    @Test(testName = "#TC0006", description = "Validate that not logged user can change sorting on the catalog page")
    public void validateSorting() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);

        catalogPage.changeSortingNameDesc(); //todo fix wait conditions for getAttributes0
        String firstProductDesc = catalogPage.getFirstProductDescription();
        String lastProductDesc = catalogPage.getLastProductDescription();
        int descending = firstProductDesc.compareTo(lastProductDesc);
        assertTrue(descending > 0, "Products are not sorted by names - descending");

        catalogPage.changeSortingNameAsc();
        String firstProductAsc = catalogPage.getFirstProductDescription();
        String lastProductAsc = catalogPage.getLastProductDescription();
        int ascending = firstProductAsc.compareTo(lastProductAsc);
        assertTrue(ascending <= 0, "Products are not sorted by names - ascending");
    }

    @Test(testName = "#TC0007", description = "Validate that not logged user can use the drawing function and successfully save the drawing on the phone")
    public void validateDrawing() throws IOException, ImageException {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        MenuPageBase menuPage = catalogPage.clickMoreButton();
        DrawingPageBase drawingPage = menuPage.clickDrawingButton();
        boolean draw = drawingPage.draw(194, 523, 91, 274);
        assertTrue(draw, "Drawing was not completed successfully");
    }

    @Test(testName = "#TC0008", description = "Validate that not logged user can successfully redirect from the app to the company page")
    public void validateAboutPage() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        MenuPageBase menuPage = catalogPage.clickMoreButton();
        AboutPageBase aboutPage = menuPage.clickAboutButton();
        SauceLabsBase sauceLabs = aboutPage.goToSauceLabsPage();
        boolean pageOpened = sauceLabs.isPageOpened();
        assertTrue(pageOpened, "Redirection was not performed successfully!");
    }

    @Test(testName = "#TC0009", description = "Validate that geolocation is showing correct longitude and latitude")
    public void validateGeoLocation() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        MenuPageBase menuPage = catalogPage.clickMoreButton();
        GeoLocationPageBase geoLocationPage = menuPage.clickGeoLocationButton();
        String latitude = geoLocationPage.getLatitude();
        String longitude = geoLocationPage.getLongitude();

        assertTrue(latitude.equals(R.TESTDATA.get("location-latitude"))
                        && longitude.equals(R.TESTDATA.get("location-longitude")),
                "Geolocation is not valid. " +
                        "Expected latitude: " + R.TESTDATA.get("location-latitude")
                        + "but found " + latitude
                        + " expected longitude: " + R.TESTDATA.get("location-longitude")
                        + " but found " + longitude);
    }

    @Test(testName = "#TC0010", description = "Validate that app reset button is working properly")
    public void validateResetting(){
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        MenuPageBase menuPage = catalogPage.clickMoreButton();
        MenuPageBase menuPageAfterReset = menuPage.resetApplication();
        boolean pageOpened = menuPageAfterReset.isPageOpened();
        assertTrue(pageOpened, "Reset done successfully");
    }
}
