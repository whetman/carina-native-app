package com.solvd.demoapp.pages.ios;

import com.solvd.demoapp.pages.common.CartPageBase;
import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.solvd.demoapp.pages.common.MenuPageBase;
import com.solvd.demoapp.utils.RandomIndex;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Getter
@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartPage.class);

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

    public CartPage(WebDriver driver) {
        super(driver);
        LOGGER.info("CartPage()");
        setUiLoadedMarker(cartScreen);
    }

    @Override
    public boolean removeRandomItemFromCart() {
        int size = removeItemButtons.size();
        int index = RandomIndex.randomize(size);
        LOGGER.info("removeItemFromCart(" + index + ")");
        removeItemButtons.get(index).click();
        if (!removeItemButtons.isEmpty()) {
            int newSize = removeItemButtons.size();
            return newSize > size;
        } else {
            return noItemsMessage.isDisplayed();
        }
    }

    @Override
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

    @Override
    public boolean isGoShoppingButtonVisible() {
        LOGGER.info("isGoShoppingButtonVisible()");
        return goShoppingButton.isVisible();
    }

    @Override
    public String getValue(){
        String text = value.getText();
        return text;
    }

    @Override
    public CatalogPageBase clickCatalogButton() {
        return null;
    }

    @Override
    public CartPageBase clickCartButton() {
        return null;
    }

    @Override
    public MenuPageBase clickMoreButton() {
        return null;
    }
}
