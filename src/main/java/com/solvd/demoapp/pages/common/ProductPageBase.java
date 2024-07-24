package com.solvd.demoapp.pages.common;

import com.solvd.demoapp.components.colors.Color;
import com.solvd.demoapp.components.quantity.Quantity;
import com.solvd.demoapp.components.rating.Rating;
import com.solvd.demoapp.constants.Colors;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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

    public CartPageBase addDefaultToCartAndGoToCart() {
        LOGGER.info("addDefaultToCartAndGoToCart()");
        clickAddToCartButton();
        return clickCartButton();
    }

    public ProductPageBase addDefaultToCartAndGoBack() {
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

    private Map<Colors, Boolean> colorsToChoose(){
        LOGGER.info("colorsToChoose()");
        Map<Colors, Boolean> availableColors = new HashMap<>();
        Boolean isGreenAvailable = color.getColorGreen().isVisible();
        availableColors.putIfAbsent(Colors.GREEN, isGreenAvailable);
        Boolean isBlueAvailable = color.getColorBlue().isVisible();
        availableColors.putIfAbsent(Colors.BLUE, isBlueAvailable);
        Boolean isGrayAvailable = color.getColorGray().isVisible();
        availableColors.putIfAbsent(Colors.GRAY, isGrayAvailable);
        return availableColors;
    }

    //todo fix, so it's not hardcoded (when new color added/color removed)
    public boolean selectColor() {
        LOGGER.info("selectColor()");
        boolean isColorChosen = false;
        Map<Colors, Boolean> colorsBooleanMap = colorsToChoose();
        Random rand = new Random();
        int index = rand.nextInt(colorsBooleanMap.size());
        switch(index){
            case 1:
                if(colorsBooleanMap.containsKey(Colors.BLUE) && colorsBooleanMap.get(Colors.BLUE)){
                    color.getColorBlue().click();
                    isColorChosen = true;
                }
                break;
            case 2:
                if(colorsBooleanMap.containsKey(Colors.GREEN) && colorsBooleanMap.get(Colors.GREEN)){
                    color.getColorGreen().click();
                    isColorChosen = true;
                }
                break;
            case 3:
                if(colorsBooleanMap.containsKey(Colors.GRAY) && colorsBooleanMap.get(Colors.GRAY)){
                    color.getColorGray().click();
                    isColorChosen = true;
                }
                break;
            default:
                color.getColorBlack().click();
                isColorChosen = true;
                break;
        }
        return isColorChosen;
    }

    public boolean changeQuantityAdd() {
        LOGGER.info("changeQuantityAdd()");
        Random rand = new Random();
        int number = rand.nextInt(10);
        return quantity.clickPlus(number);
    }

    public void changeQuantityRemove() {

    }
}