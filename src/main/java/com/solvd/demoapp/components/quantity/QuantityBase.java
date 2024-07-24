package com.solvd.demoapp.components.quantity;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuantityBase extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuantityBase.class);

    @ExtendedFindBy(accessibilityId = "AddPlus Icons")
    private ExtendedWebElement plusButton;

    @ExtendedFindBy(accessibilityId = "SubtractMinus Icons")
    private ExtendedWebElement minusButton;

    @ExtendedFindBy(accessibilityId = "Amount")
    private ExtendedWebElement amount;

    public QuantityBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean clickPlus(int number) {
        LOGGER.info("clickPlus(" + number + ")");
        if(number < 0){
            throw new IllegalArgumentException("Number must be grater that 0");
        }
        String value = amount.getAttribute("value");
        LOGGER.info("VALUE: " + value);
        for(int i = 0; i < number; i++){
            plusButton.click();
        }
        String changedValue = amount.getAttribute("value");
        return Integer.valueOf(changedValue) - Integer.valueOf(value) == number;
    }

    public void clickMinus(int number) {
        LOGGER.info("clickMinus(" + number + ")");
        if(number < 0){
            throw new IllegalArgumentException("Number must be grater that 0");
        }
        for(int i = 0; i < number; i++){
            minusButton.click();
        }
    }
}
