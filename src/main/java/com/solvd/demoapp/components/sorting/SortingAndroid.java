package com.solvd.demoapp.components.sorting;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SortingAndroid extends SortingBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(SortingAndroid.class);

    @ExtendedFindBy(accessibilityId = "Displays ascending sorting order by name")
    private ExtendedWebElement sortNameAscending;

    @ExtendedFindBy(accessibilityId = "Descending order by name")
    private ExtendedWebElement sortNameDescending;

    @ExtendedFindBy(accessibilityId = "Ascending order by price")
    private ExtendedWebElement sortPriceAscending;

    @ExtendedFindBy(accessibilityId = "Descending order by price")
    private ExtendedWebElement sortPriceDescending;

    public SortingAndroid(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        LOGGER.info("SortingAndroid()");
    }

    @Override
    public void clickNameAsc() {
        LOGGER.info("clickNameAsc()");
        sortNameAscending.click();
    }

    @Override
    public void clickNameDesc() {
        LOGGER.info("clickNameDesc()");
        sortNameDescending.click();
    }

    @Override
    public void clickPriceAsc() {
        LOGGER.info("clickPriceAsc()");
        sortPriceAscending.click();
    }

    @Override
    public void clickPriceDesc() {
        LOGGER.info("clickPriceDesc()");
        sortPriceDescending.click();
    }
}
