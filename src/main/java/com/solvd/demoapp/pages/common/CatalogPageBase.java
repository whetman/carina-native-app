package com.solvd.demoapp.pages.common;

import com.solvd.demoapp.components.product.Product;
import com.solvd.demoapp.components.sorting.Sorting;
import com.solvd.demoapp.utils.RandomIndex;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Getter
public abstract class CatalogPageBase extends PageBaseWithOkButton {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogPageBase.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"Catalog-screen\"`]")
    private ExtendedWebElement catalogScreen;

    @ExtendedFindBy(iosPredicate = "name == \"ProductItem\"")
    private List<Product> products;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Button\"`]")
    private ExtendedWebElement sortButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[$type == 'XCUIElementTypeButton' AND name == 'Name - Ascending'$][-1]")
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
        int index = RandomIndex.randomize(products.size());
        LOGGER.info("clickRandomProduct(" + index + ")");
        return clickProduct(index);
    }

    public ProductPageBase addRandomProductToCart() {
        int index = RandomIndex.randomize(products.size());
        LOGGER.info("addRandomProductToCart(" + index + ")");
        return clickProduct(index);
    }

    public ExtendedWebElement rateRandomProduct() {
        int index = RandomIndex.randomize(products.size());
        LOGGER.info("rateRandomProduct(" + index + ")");
        Product product = products.get(index);
        product.rateProduct();
        return okButton;
    }

    public void changeSortingNameAsc() {
        LOGGER.info("changeSortingNameAsc()");
        sortButton.click();
        sorting.clickNameAsc();
    }

    public void changeSortingNameDesc() {
        LOGGER.info("changeSortingNameDesc()");
        sortButton.click();
        sorting.clickNameDesc();
    }

    public void changeSortingPriceAsc() {
        LOGGER.info("changeSortingPriceAsc()");
        sortButton.click();
        sorting.clickPriceAsc();
    }

    public void changeSortingPriceDesc() {
        LOGGER.info("changeSortingPriceDesc()");
        sortButton.click();
        sorting.clickPriceDesc();
    }
}
