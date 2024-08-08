package com.solvd.demoapp.pages.common;

import com.solvd.demoapp.components.header.Header;
import com.solvd.demoapp.components.product.Product;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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

    public abstract List<Product> getProducts();

}
