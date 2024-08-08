package com.solvd.demoapp.components.sorting;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SortingIOS extends SortingBase{
    private static final Logger LOGGER = LoggerFactory.getLogger(SortingIOS.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Name - Ascending\"`]")
    private ExtendedWebElement sortNameAscending;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Name - Descending\"`]")
    private ExtendedWebElement sortNameDescending;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Price - Ascending\"`]")
    private ExtendedWebElement sortPriceAscending;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Price - Descending\"`]")
    private ExtendedWebElement sortPriceDescending;

    public SortingIOS(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        LOGGER.info("Sorting()");
    }

    @Override
    public void clickNameAsc(){
        LOGGER.info("clickNameAsc()");
        sortNameAscending.click();
    }

    @Override
    public void clickNameDesc(){
        LOGGER.info("clickNameDesc()");
        sortNameDescending.click();
    }

    @Override
    public void clickPriceAsc(){
        LOGGER.info("clickPriceAsc()");
        sortPriceAscending.click();
    }

    @Override
    public void clickPriceDesc(){
        LOGGER.info("clickPriceDesc()");
        sortPriceDescending.click();
    }
}
