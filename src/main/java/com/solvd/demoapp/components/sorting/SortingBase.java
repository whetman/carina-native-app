package com.solvd.demoapp.components.sorting;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public abstract class SortingBase extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(SortingBase.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Name - Ascending\"`]")
    private ExtendedWebElement sortNameAscending;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Name - Descending\"`]")
    private ExtendedWebElement sortNameDescending;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Price - Ascending\"`]")
    private ExtendedWebElement sortPriceAscending;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Price - Descending\"`]")
    private ExtendedWebElement sortPriceDescending;

    public SortingBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickNameAsc(){
        LOGGER.info("clickNameAsc()");
        sortNameAscending.click();
    }

    public void clickNameDesc(){
        LOGGER.info("clickNameDesc()");
        sortNameDescending.click();
    }

    public void clickPriceAsc(){
        LOGGER.info("clickPriceAsc()");
        sortPriceAscending.click();
    }

    public void clickPriceDesc(){
        LOGGER.info("clickPriceDesc()");
        sortPriceDescending.click();
    }
}
