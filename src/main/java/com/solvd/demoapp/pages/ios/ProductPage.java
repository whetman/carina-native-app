package com.solvd.demoapp.pages.ios;

import com.solvd.demoapp.components.colors.Color;
import com.solvd.demoapp.components.quantity.QuantityIOS;
import com.solvd.demoapp.components.rating.RatingIOS;
import com.solvd.demoapp.constants.Colors;
import com.solvd.demoapp.pages.common.CartPageBase;
import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.solvd.demoapp.pages.common.MenuPageBase;
import com.solvd.demoapp.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

@Getter
@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductPageBase.class);

    @ExtendedFindBy(iosPredicate = "name == \"AddToCart\"")
    private ExtendedWebElement addToCartButton;

    @ExtendedFindBy(accessibilityId = "Price")
    private ExtendedWebElement price;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]" +
            "/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]")
    private RatingIOS rating;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]" +
            "/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeButton")
    private List<Color> color;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]" +
            "/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]")
    private QuantityIOS quantity;

    @ExtendedFindBy(accessibilityId = "Cart-tab-item")
    private ExtendedWebElement cartButton;

    @ExtendedFindBy(accessibilityId = "OK")
    protected ExtendedWebElement okButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        LOGGER.info("ProductPage()");
        setUiLoadedMarker(addToCartButton);
    }

    public CartPageBase addToCartAndGoToCart() {
        LOGGER.info("addDefaultToCartAndGoToCart()");
        clickAddToCartButton();
        return clickCartButton();
    }

    public void clickAddToCartButton() {
        LOGGER.info("clickAddToCartButton()");
        addToCartButton.click();
    }

    public ExtendedWebElement rateProduct() {
        LOGGER.info("rateProduct()");
        rating.clickRandomSelectedStar();
        return okButton;
    }

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

    public boolean changeQuantityAdd() {
        LOGGER.info("changeQuantityAdd()");
        Random rand = new Random();
        int number = rand.nextInt(10);
        return quantity.clickPlus(number);
    }

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
        cartButton.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public MenuPageBase clickMoreButton() {
        return null;
    }
}
