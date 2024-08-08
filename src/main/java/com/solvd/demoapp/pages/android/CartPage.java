package com.solvd.demoapp.pages.android;

import com.solvd.demoapp.pages.common.CartPageBase;
import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.solvd.demoapp.pages.common.MenuPageBase;
import com.solvd.demoapp.utils.RandomIndex;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Getter
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartPage.class);

    @FindBy(className = "android.widget.Button")
    private ExtendedWebElement goShoppingButton;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/noItemTitleTV")
    private ExtendedWebElement noItemsMessage;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/noItemCL")
    private ExtendedWebElement cartScreen;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/removeBt")
    private List<ExtendedWebElement> removeItemButtons;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    private ExtendedWebElement plusButton;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/minusIV")
    private ExtendedWebElement minusButton;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
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
    public String getValue() {
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
