package com.solvd.demoapp.components.product;

import com.solvd.demoapp.components.rating.RatingIOS;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Getter
public class ProductIOS extends ProductBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductIOS.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther")
    private RatingIOS rating;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText")
    private List<ExtendedWebElement> productAttributes;

    public ProductIOS(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        LOGGER.info("ProductIOS()");
    }

    @Override
    public void rateProduct() {
        LOGGER.info("rateProduct()");
        rating.clickRandomSelectedStar();
    }

}
