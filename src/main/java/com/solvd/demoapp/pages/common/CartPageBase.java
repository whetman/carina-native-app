package com.solvd.demoapp.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

@Getter
public abstract class CartPageBase extends PageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartPageBase.class);

    @ExtendedFindBy(accessibilityId = "GoShopping")
    private ExtendedWebElement goShoppingButton;

    @ExtendedFindBy(accessibilityId = "No Items")
    private ExtendedWebElement noItemsMessage;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"Cart-screen\"`]")
    private ExtendedWebElement cartScreen;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == \"Remove Item\"`]")
    private List<ExtendedWebElement> removeItemButtons;

    @ExtendedFindBy(accessibilityId = "AddPlus Icons")
    private ExtendedWebElement plusButton;

    @ExtendedFindBy(accessibilityId = "SubtractMinus Icons")
    private ExtendedWebElement minusButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeCell/XCUIElementTypeStaticText[5]")
    private ExtendedWebElement value;

    public CartPageBase(WebDriver driver) {
        super(driver);
        LOGGER.info("CartPageBase()");
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(this.cartScreen);
    }

    public boolean removeRandomItemFromCart() {
        Random rand = new Random();
        int size = removeItemButtons.size();
        int index = rand.nextInt(size);
        LOGGER.info("removeItemFromCart(" + index + ")");
        removeItemButtons.get(index).click();
        if (!removeItemButtons.isEmpty()) {
            int newSize = removeItemButtons.size();
            return newSize > size;
        } else {
            return noItemsMessage.isDisplayed();
        }
    }

    public boolean removeItemsWithMinusButton(String value) {
        LOGGER.info("removeItemsWithMinusButton(" + value + ")");
        if (value.isEmpty()) {
            throw new IllegalArgumentException("Invalid value");
        }
        int amount = Integer.parseInt(value);
        int count = 0;
        while (minusButton.isVisible()) {
            minusButton.click();
            count++;
        }
        return count == amount;
    }

    public boolean isGoShoppingButtonVisible() {
        LOGGER.info("isGoShoppingButtonVisible()");
        return goShoppingButton.isVisible();
    }

    public String getValue(){
        String text = value.getText();
        return text;
    }
}
