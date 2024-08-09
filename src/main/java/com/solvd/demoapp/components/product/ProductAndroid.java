package com.solvd.demoapp.components.product;

import com.solvd.demoapp.components.rating.RatingAndroid;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProductAndroid extends ProductBase{
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductAndroid.class);

    @FindBy(xpath = ".//android.view.ViewGroup[@resource-id=\"com.saucelabs.mydemoapp.android:id/rattingV\"]")
    private RatingAndroid rating;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText")
    private List<ExtendedWebElement> productAttributes;

    public ProductAndroid(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        LOGGER.info("ProductAndroid()");
    }

    @Override
    public void rateProduct() {
        LOGGER.info("rateProduct()");
        rating.clickRandomStar();
    }

    @Override
    public List<ExtendedWebElement> getProductAttributes() {
        return null;
    }
}
