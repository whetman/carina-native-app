package com.solvd.demoapp.components.product;

import com.solvd.demoapp.components.rating.Rating;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Getter
public abstract class ProductBase extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductBase.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther")
    private Rating rating;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText")
    private List<ExtendedWebElement> productAttributes;

    public ProductBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void rateProduct() {
        LOGGER.info("rateProduct()");
        rating.clickRandomSelectedStar();
    }

}
