package com.solvd.demoapp.components.sorting;

import com.solvd.demoapp.components.product.Product;
import com.solvd.demoapp.constants.Products;
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

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductItem\"`][1]/XCUIElementTypeImage")
    private ExtendedWebElement firstProductOnThePage;

    //todo get first and get last, compare first letters
    @ExtendedFindBy(iosClassChain = "/XCUIElementTypeOther[`name == \"ProductItem\"`]")
    private List<Product> products;

    //todo list of prices on the page, get first, get last, compare

    public SortingBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean validateNameAscending(){
        LOGGER.info("validateNameAscending()");
        return firstProductOnThePage.getAttribute("name").contains(Products.BAGBLACK.getName());
    }

    public boolean validateNameDescending(){
        LOGGER.info("validateNameDescending()");
        LOGGER.info("NAME: " + firstProductOnThePage.getAttribute("name"));
        LOGGER.info("ENUM NAME: " + Products.SHIRTRED.getName());
        LOGGER.info("CONTAINS: " + firstProductOnThePage.getAttribute("name").contains(Products.SHIRTRED.getName()));
        return firstProductOnThePage.getAttribute("name").contains(Products.SHIRTRED.getName());
    }

    public boolean validatePriceAscending(){
        LOGGER.info("validatePriceAscending()");
        return firstProductOnThePage.getAttribute("name").contains(Products.SHIRTRED.getName()) || firstProductOnThePage.getAttribute("name").contains(Products.SHIRTBLACK.getName());
    }

    public boolean validatePriceDescending(){
        LOGGER.info("validatePriceDescending()");
        return firstProductOnThePage.getAttribute("name").contains(Products.BIKELIGHT.getName());
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
