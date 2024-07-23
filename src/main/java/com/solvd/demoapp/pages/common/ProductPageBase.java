package com.solvd.demoapp.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ProductPageBase extends PageBase{
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductPageBase.class);

    @ExtendedFindBy(iosPredicate = "name == \"AddToCart\"")
    private ExtendedWebElement addToCartButton;
//    todo change locators if possible
//    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]")
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]")
    private ExtendedWebElement rating;

//    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]")
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]")
    private ExtendedWebElement colorsAvailable; //list +enums

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]")
    private ExtendedWebElement quantityButtons; //component? + -

    @ExtendedFindBy(accessibilityId = "Price")
    private ExtendedWebElement price;

    @ExtendedFindBy(accessibilityId = "BackButton Icons")
    private ExtendedWebElement goBackButton;

    public ProductPageBase(WebDriver driver) {
        super(driver);
        LOGGER.info("ProductPageBase()");
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(this.addToCartButton);
    }

    public CartPageBase addDefaultToCartAndGoToCart(){
        LOGGER.info("addDefaultToCartAndGoToCart()");
        clickAddToCartButton();
        clickCartButton();
        return initPage(getDriver(), CartPageBase.class);
    }

    public ProductPageBase addDefaultToCartAndGoBack(){
        LOGGER.info("addDefaultToCartAndGoBack()");
        clickAddToCartButton();
        return clickGoBackButton();
    }

    public void clickAddToCartButton(){
        LOGGER.info("clickAddToCartButton()");
        addToCartButton.click();
    }

    public ProductPageBase clickGoBackButton(){
        LOGGER.info("clickGoBackButton()");
        goBackButton.click();
        return initPage(getDriver(), ProductPageBase.class);
    }
}
