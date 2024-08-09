package com.solvd.demoapp.components.quantity;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public abstract class QuantityBase extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuantityBase.class);

    public QuantityBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract boolean clickPlus(int number);

    public abstract boolean clickMinus(int number);

    public abstract ExtendedWebElement getAmount();
}
