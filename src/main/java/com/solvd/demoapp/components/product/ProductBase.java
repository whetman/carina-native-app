package com.solvd.demoapp.components.product;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ProductBase extends AbstractUIObject {
    public ProductBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
