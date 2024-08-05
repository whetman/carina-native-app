package com.solvd.demoapp.pages.common;

import com.solvd.demoapp.components.product.Product;
import com.solvd.demoapp.components.sorting.Sorting;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

public abstract class CatalogPageBase extends PageBaseWithOkButton {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogPageBase.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"Catalog-screen\"`]")
    private ExtendedWebElement catalogScreen;

    @ExtendedFindBy(iosPredicate = "name == \"ProductItem\"")
    private List<Product> products;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Button\"`]")
    private ExtendedWebElement sortButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]")
    private Sorting sorting;

    public CatalogPageBase(WebDriver driver) {
        super(driver);
        LOGGER.info("CatalogPageBase()");
        setUiLoadedMarker(catalogScreen);
    }

    private ProductPageBase clickProduct(int index) {
        products.get(index).click();
        return initPage(getDriver(), ProductPageBase.class);
    }

    public ProductPageBase clickRandomProduct() {
        LOGGER.info("clickRandomProduct()");
        Random rand = new Random();
        int index = rand.nextInt(products.size());
        LOGGER.info("clickRandomProduct(" + index + ")");
        return clickProduct(index);
    }

    public ProductPageBase addRandomProductToCart() {
        Random rand = new Random();
        int index = rand.nextInt(products.size());
        LOGGER.info("addRandomProductToCart(" + index + ")");
        return clickProduct(index);
    }

    public ExtendedWebElement rateRandomProduct() {
        Random rand = new Random();
        int index = rand.nextInt(products.size());
        LOGGER.info("rateRandomProduct(" + index + ")");
        Product product = products.get(index);
        product.rateProduct();
        return okButton;
    }

    public boolean changeSortingNameAsc() {
        LOGGER.info("changeSortingNameAsc()");
        sortButton.click();
        sorting.clickNameAsc();
        return sorting.validateNameAscending();
    }

    public boolean changeSortingNameDesc() {
        LOGGER.info("changeSortingNameDesc()");
        sortButton.click();
        sorting.clickNameDesc();
        return sorting.validateNameDescending();
    }

    public boolean changeSortingPriceAsc() {
        LOGGER.info("changeSortingPriceAsc()");
        sortButton.click();
        sorting.clickPriceAsc();
        return sorting.validatePriceAscending();
    }

    public boolean changeSortingPriceDesc() {
        LOGGER.info("changeSortingPriceDesc()");
        sortButton.click();
        sorting.clickPriceDesc();
        return sorting.validatePriceDescending();
    }
}
