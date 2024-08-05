package com.solvd.demoapp.pages.common;

import com.solvd.demoapp.components.colors.Color;
import com.solvd.demoapp.components.quantity.Quantity;
import com.solvd.demoapp.components.rating.Rating;
import com.solvd.demoapp.constants.Colors;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

@Getter
public abstract class ProductPageBase extends PageBaseWithOkButton {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductPageBase.class);

    @ExtendedFindBy(iosPredicate = "name == \"AddToCart\"")
    private ExtendedWebElement addToCartButton;

    @ExtendedFindBy(accessibilityId = "Price")
    private ExtendedWebElement price;

    @ExtendedFindBy(accessibilityId = "BackButton Icons")
    private ExtendedWebElement goBackButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]" +
            "/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]")
    private Rating rating;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]" +
            "/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeButton")
    private List<Color> color;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]" +
            "/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]")
    private Quantity quantity;

    public ProductPageBase(WebDriver driver) {
        super(driver);
        LOGGER.info("ProductPageBase()");
        setUiLoadedMarker(addToCartButton);
    }

    public CartPageBase addToCartAndGoToCart() {
        LOGGER.info("addDefaultToCartAndGoToCart()");
        clickAddToCartButton();
        return clickCartButton();
    }

    public ProductPageBase addToCartAndGoBack() {
        LOGGER.info("addDefaultToCartAndGoBack()");
        clickAddToCartButton();
        return clickGoBackButton();
    }

    public void clickAddToCartButton() {
        LOGGER.info("clickAddToCartButton()");
        addToCartButton.click();
    }

    public ProductPageBase clickGoBackButton() {
        LOGGER.info("clickGoBackButton()");
        goBackButton.click();
        return initPage(getDriver(), ProductPageBase.class);
    }

    public ExtendedWebElement rateProduct() {
        LOGGER.info("rateProduct()");
        rating.clickRandomSelectedStar();
        return okButton;
    }

    public boolean selectColor(Colors chosenColor) {
        LOGGER.info("selectColor(" + chosenColor.getColor() + ")");
        if (color.size() == 1) {
            LOGGER.info("The product has only one default color. Nothing to change.");
            return true;
        }
        return color.stream().filter(e -> chosenColor.getColor().equals(e.getAttribute("name"))).findFirst().map(e -> {
            e.click();
            return true;
        }).orElse(false);
    }

    public boolean changeQuantityAdd() {
        LOGGER.info("changeQuantityAdd()");
        Random rand = new Random();
        int number = rand.nextInt(10);
        return quantity.clickPlus(number);
    }

    public boolean changeQuantityRemove() {
        LOGGER.info("changeQuantityRemove()");
        String value = quantity.getAmount().getAttribute("value");
        if (Integer.parseInt(value) > 0) {
            Random rand = new Random();
            int number = rand.nextInt(Integer.parseInt(value));
            return quantity.clickMinus(number);
        } else return false;
    }
}