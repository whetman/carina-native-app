package com.solvd.demoapp.components.quantity;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class QuantityAndroid extends QuantityBase{
    private static final Logger LOGGER = LoggerFactory.getLogger(QuantityAndroid.class);

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    private ExtendedWebElement plusButton;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/minusIV")
    private ExtendedWebElement minusButton;

    @FindBy(id = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/noTV\"]")
    private ExtendedWebElement amount;

    public QuantityAndroid(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        LOGGER.info("Quantity()");
    }

    @Override
    public boolean clickPlus(int number) {
        LOGGER.info("clickPlus(" + number + ")");
        String value = amount.getAttribute("value");
        return buttonClick(number, value, plusButton) - Integer.parseInt(value) == number;
    }

    @Override
    public boolean clickMinus(int number) {
        LOGGER.info("clickMinus(" + number + ")");
        String value = amount.getAttribute("value");
        if (number > Integer.parseInt(value)) {
            throw new IllegalArgumentException("Number must be less than existing quantity");
        }
        return buttonClick(number, value, minusButton) + number == Integer.parseInt(value);
    }

    private Integer buttonClick(int number, String value, ExtendedWebElement extendedWebElement) {
        LOGGER.info("buttonClick()");
        if (number < 0) {
            throw new IllegalArgumentException("Number must be grater that 0");
        }
        for (int i = 0; i < number; i++) {
            extendedWebElement.click();
        }
        String changedValue = amount.getAttribute("value");
        return Integer.parseInt(changedValue);
    }
}