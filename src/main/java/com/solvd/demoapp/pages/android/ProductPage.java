package com.solvd.demoapp.pages.android;

import com.solvd.demoapp.components.colors.Color;
import com.solvd.demoapp.components.header.Header;
import com.solvd.demoapp.components.quantity.QuantityBase;
import com.solvd.demoapp.components.rating.RatingAndroid;
import com.solvd.demoapp.constants.Colors;
import com.solvd.demoapp.pages.common.CartPageBase;
import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.solvd.demoapp.pages.common.MenuPageBase;
import com.solvd.demoapp.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

@Getter
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductPage.class);

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    private ExtendedWebElement addToCartButton;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
    private ExtendedWebElement price;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/rattingV")
    private RatingAndroid rating;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/colorRV")
    private List<Color> color;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.saucelabs.mydemoapp.android:id/addToCartLL\"]")
    private QuantityBase quantity;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/header")
    private Header header;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/closeBt")
    protected ExtendedWebElement continueButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        LOGGER.info("ProductPage()");
        setUiLoadedMarker(addToCartButton);
    }

    @Override
    public CartPageBase addToCartAndGoToCart() {
        LOGGER.info("addDefaultToCartAndGoToCart()");
        clickAddToCartButton();
        return clickCartButton();
    }

    @Override
    public void clickAddToCartButton() {
        LOGGER.info("clickAddToCartButton()");
        addToCartButton.click();
    }

    @Override
    public ExtendedWebElement rateProduct() {
        LOGGER.info("rateProduct()");
        rating.clickRandomStar();
        return continueButton;
    }

    @Override
    public boolean selectColor(Colors chosenColor) {
        LOGGER.info("selectColor(" + chosenColor.getColor() + ")");
        if (color.size() == 1) {
            LOGGER.info("The product has only one default color. Nothing to change.");
            return true;
        }
        return color.stream().filter(e -> chosenColor.getColor().equals(e.getAttribute("name"))).findFirst().map(e -> {
            e.click();
            return true;
        }).orElse(false);
    }

    @Override
    public boolean changeQuantityAdd() {
        LOGGER.info("changeQuantityAdd()");
        Random rand = new Random();
        int number = rand.nextInt(10);
        return quantity.clickPlus(number);
    }

    @Override
    public boolean changeQuantityRemove() {
        LOGGER.info("changeQuantityRemove()");
        String value = quantity.getAmount().getAttribute("value");
        if (Integer.parseInt(value) > 0) {
            Random rand = new Random();
            int number = rand.nextInt(Integer.parseInt(value));
            return quantity.clickMinus(number);
        } else return false;
    }

    @Override
    public CatalogPageBase clickCatalogButton() {
        return null;
    }

    @Override
    public CartPageBase clickCartButton() {
        LOGGER.info("clickCartButton()");
        header.getCartButton().click();
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public MenuPageBase clickMoreButton() {
        return null;
    }
}
