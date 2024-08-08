package com.solvd.demoapp.pages.common;

import com.solvd.demoapp.components.header.Header;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CatalogPageBase extends PageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogPageBase.class);

    public CatalogPageBase(WebDriver driver) {
        super(driver);
        LOGGER.info("CatalogPageBase()");
    }

    public abstract ProductPageBase clickProduct(int index);

    public abstract ProductPageBase clickRandomProduct();

    public abstract ProductPageBase addRandomProductToCart();

    public abstract ExtendedWebElement rateRandomProduct();

    public abstract void changeSortingNameAsc();

    public abstract void changeSortingNameDesc();

    public abstract void changeSortingPriceAsc();

    public abstract void changeSortingPriceDesc();

    public abstract Header getHeader();

    public abstract String getFirstProductDescription();

    public abstract String getLastProductDescription();

}
