package com.solvd.demoapp.components.product;

import com.solvd.demoapp.components.rating.Rating;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ProductBase extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductBase.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther")
    private Rating rating;

    public ProductBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void rateProduct() {
        LOGGER.info("rateProduct()");
        rating.clickRandomSelectedStar();
    }

}
