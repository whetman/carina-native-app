package com.solvd.demoapp.pages.common;

import com.solvd.demoapp.components.colors.Color;
import com.solvd.demoapp.components.quantity.Quantity;
import com.solvd.demoapp.components.rating.Rating;
import com.solvd.demoapp.constants.Colors;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Getter
public abstract class ProductPageBase extends PageBaseWithOkButton {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductPageBase.class);

    @ExtendedFindBy(iosPredicate = "name == \"AddToCart\"")
    private ExtendedWebElement addToCartButton;

    @ExtendedFindBy(accessibilityId = "Price")
    private ExtendedWebElement price;

    @ExtendedFindBy(accessibilityId = "BackButton Icons")
    private ExtendedWebElement goBackButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]" +
            "/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]")
    private Rating rating;

    //todo make list of colors if possible
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]" +
            "/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]")
    private Color color;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]" +
            "/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]")
    private Quantity quantity;

    public ProductPageBase(WebDriver driver) {
        super(driver);
        LOGGER.info("ProductPageBase()");
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(this.addToCartButton);
    }

    public CartPageBase addToCartAndGoToCart() {
        LOGGER.info("addDefaultToCartAndGoToCart()");
        clickAddToCartButton();
        return clickCartButton();
    }

    public ProductPageBase addToCartAndGoBack() {
        LOGGER.info("addDefaultToCartAndGoBack()");
        clickAddToCartButton();
        return clickGoBackButton();
    }

    public void clickAddToCartButton() {
        LOGGER.info("clickAddToCartButton()");
        addToCartButton.click();
    }

    public ProductPageBase clickGoBackButton() {
        LOGGER.info("clickGoBackButton()");
        goBackButton.click();
        return initPage(getDriver(), ProductPageBase.class);
    }

    public ExtendedWebElement rateProduct() {
        LOGGER.info("rateProduct()");
        rating.clickRandomSelectedStar();
        return okButton;
    }

    //todo fix - it's too slow
    private Map<Colors, Boolean> colorsToChoose() {
        LOGGER.info("colorsToChoose()");
        Map<Colors, Boolean> availableColors = new HashMap<>();
        Boolean isBlackAvailable = color.getColorBlack().isVisible();
        availableColors.putIfAbsent(Colors.BLACK, isBlackAvailable);
        Boolean isGreenAvailable = color.getColorGreen().isVisible();
        availableColors.putIfAbsent(Colors.GREEN, isGreenAvailable);
        Boolean isBlueAvailable = color.getColorBlue().isVisible();
        availableColors.putIfAbsent(Colors.BLUE, isBlueAvailable);
        Boolean isGrayAvailable = color.getColorGray().isVisible();
        availableColors.putIfAbsent(Colors.GRAY, isGrayAvailable);
        return availableColors;
    }

    public boolean selectColor(Colors chosenColor) {
        LOGGER.info("selectColor()");
        boolean isColorChosen = false;
        Map<Colors, Boolean> colorsBooleanMap = colorsToChoose();

        if (colorsBooleanMap.get(chosenColor)) {
            switch (chosenColor) {
                case Colors.BLUE -> color.getColorBlue().click();
                case Colors.GRAY -> color.getColorGray().click();
                case Colors.GREEN -> color.getColorGreen().click();
                default -> color.getColorBlack().click();
            }
            isColorChosen = true;
        } else {
            color.getColorBlack().click();
            isColorChosen = true;
        }
        return isColorChosen;
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
}