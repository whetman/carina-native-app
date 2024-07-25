package com.solvd.tests.demoapp;

import com.solvd.demoapp.constants.Colors;
import com.solvd.demoapp.pages.common.AboutPageBase;
import com.solvd.demoapp.pages.common.CartPageBase;
import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.solvd.demoapp.pages.common.DrawingPageBase;
import com.solvd.demoapp.pages.common.GeoLocationPageBase;
import com.solvd.demoapp.pages.common.LoginPageBase;
import com.solvd.demoapp.pages.common.ProductPageBase;
import com.solvd.demoapp.pages.common.RightMenuPageBase;
import com.solvd.demoapp.pages.common.SauceLabsBase;
import com.solvd.tests.AbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.testng.annotations.Test;

import java.io.IOException;

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

    @Test(testName = "#TC0004", description = "Validate that not logged user can add multiple products with different colors/sizes to the cart and delete them from the cart")
    public void validateChangingProductProperties() throws NoSuchFieldException, IllegalAccessException {
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

        String valueInTheCart = cartPage.getValue();
        boolean isQuantityTheSame = valueInTheCart.equals(valueOnProductPage);
        assertTrue(isQuantityTheSame, "Quantity is not the same");

        boolean isRemoved = cartPage.removeItemsWithMinusButton(valueOnProductPage);
        assertTrue(isRemoved, "Items were not removed successfully");

        boolean isGoShoppingVisible = cartPage.isGoShoppingButtonVisible();
        assertTrue(isGoShoppingVisible, "Go shopping button is not visible");
    }

    //todo change validation in sorting
    @Test(testName = "#TC0005", description = "Validate that not logged user can change sorting on the catalog page")
    public void validateSorting() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);

        boolean descendingNames = catalogPage.changeSortingNameDesc();
        assertTrue(descendingNames, "Products are not sorted by names - descending");

        boolean ascendingNames = catalogPage.changeSortingNameAsc();
        assertTrue(ascendingNames, "Products are not sorted by names - ascending");

        boolean ascendingPrices = catalogPage.changeSortingPriceAsc();
        assertTrue(ascendingPrices, "Products are not sorted by prices - ascending");

        boolean descendingPrices = catalogPage.changeSortingPriceDesc();
        assertTrue(descendingPrices, "Products are not sorted by prices - descending");
    }

    @Test(testName = "#TC0006", description = "Validate that not logged user can use the drawing function and successfully save the drawing on the phone")
    public void validateDrawing() throws IOException {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        RightMenuPageBase rightMenuPage = catalogPage.clickMoreButton();
        DrawingPageBase drawingPage = rightMenuPage.clickDrawingButton();
        boolean draw = drawingPage.draw(194, 523, 91, 274);
        assertTrue(draw, "Drawing was not completed successfully");
    }

    @Test(testName = "#TC0007", description = "Validate that not logged user can successfully redirect from the app to the company page")
    public void validateAboutPage() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        RightMenuPageBase rightMenuPage = catalogPage.clickMoreButton();
        AboutPageBase aboutPage = rightMenuPage.clickAboutButton();
        SauceLabsBase sauceLabs = aboutPage.goToSauceLabsPage();
        boolean pageOpened = sauceLabs.isPageOpened();
        assertTrue(pageOpened, "Redirection was not performed successfully!");
    }

    @Test(testName = "#TC0008", description = "Validate that geolocation is showing correct longitude and latitude")
    public void validateGeoLocation() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        RightMenuPageBase rightMenuPage = catalogPage.clickMoreButton();
        GeoLocationPageBase geoLocationPage = rightMenuPage.clickGeoLocationButton();
        String latitude = geoLocationPage.getLatitude();
        String longitude = geoLocationPage.getLongitude();

        assertTrue(latitude.equals(R.TESTDATA.get("location-latitude"))
                        && longitude.equals(R.TESTDATA.get("location-longitude")),
                "Geolocation is not valid");
    }

}
