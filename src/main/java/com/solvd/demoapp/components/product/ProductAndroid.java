package com.solvd.demoapp.components.product;

import com.solvd.demoapp.components.rating.RatingAndroid;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductAndroid extends ProductBase{
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductAndroid.class);

    @FindBy(xpath = ".//android.view.ViewGroup[@resource-id=\"com.saucelabs.mydemoapp.android:id/rattingV\"]")
    private RatingAndroid rating;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/titleTV\"]")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/priceTV\"]")
    private ExtendedWebElement productPrice;

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
        LOGGER.info("getProductAttributes({}, {})", productName.getText(), productPrice.getText());
        List<ExtendedWebElement> productAttributes = new ArrayList<>();
        productAttributes.add(productName);
        productAttributes.add(productPrice);
        return productAttributes;
    }
}
