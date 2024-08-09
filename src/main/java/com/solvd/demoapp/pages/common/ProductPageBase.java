package com.solvd.demoapp.pages.common;

import com.solvd.demoapp.components.quantity.QuantityBase;
import com.solvd.demoapp.constants.Colors;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ProductPageBase extends PageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductPageBase.class);

    public ProductPageBase(WebDriver driver) {
        super(driver);
        LOGGER.info("ProductPageBase()");
    }

    public abstract CartPageBase addToCartAndGoToCart();

    public abstract void clickAddToCartButton();

    public abstract ExtendedWebElement rateProduct();

    public abstract boolean selectColor(Colors chosenColor);

    public abstract boolean changeQuantityAdd();

    public abstract boolean changeQuantityRemove();

    public abstract QuantityBase getQuantity();
}