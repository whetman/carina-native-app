package com.solvd.demoapp.pages.common;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CartPageBase extends PageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartPageBase.class);

    public CartPageBase(WebDriver driver) {
        super(driver);
        LOGGER.info("CartPageBase()");
    }

    public abstract boolean removeRandomItemFromCart();

    public abstract boolean removeItemsWithMinusButton(String value);

    public abstract boolean isGoShoppingButtonVisible();

    public abstract String getValue();
}
