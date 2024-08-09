package com.solvd.demoapp.pages.android;

import com.solvd.demoapp.components.header.Header;
import com.solvd.demoapp.components.product.ProductAndroid;
import com.solvd.demoapp.components.sorting.SortingAndroid;
import com.solvd.demoapp.pages.common.CartPageBase;
import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.solvd.demoapp.pages.common.MenuPageBase;
import com.solvd.demoapp.pages.common.ProductPageBase;
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
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CatalogPageBase.class)
public class CatalogPage extends CatalogPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogPage.class);

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/header")
    private Header header;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays all products of catalog\"]/android.view.ViewGroup")
    private List<ProductAndroid> products;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/sortIV")
    private ExtendedWebElement sortButton;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup")
    private SortingAndroid sorting;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/closeBt")
    protected ExtendedWebElement continueButton;

    public CatalogPage(WebDriver driver) {
        super(driver);
        LOGGER.info("CatalogPage()");
        setUiLoadedMarker(pageTitle);
    }

    @Override
    public ProductPageBase clickProduct(int index) {
        LOGGER.info("clickProduct({})", index);
        products.get(index).click();
        return initPage(getDriver(), ProductPageBase.class);
    }

    @Override
    public ProductPageBase clickRandomProduct() {
        LOGGER.info("clickRandomProduct()");
        int index = RandomIndex.randomize(products.size());
        LOGGER.info("clickRandomProduct(" + index + ")");
        return clickProduct(index);
    }

    @Override
    public ExtendedWebElement rateRandomProduct() {
        int index = RandomIndex.randomize(products.size());
        LOGGER.info("rateRandomProduct(" + index + ")");
        ProductAndroid product = products.get(index);
        product.rateProduct();
        return continueButton;
    }

    @Override
    public void changeSortingNameAsc() {
        LOGGER.info("changeSortingNameAsc()");
        sortButton.click();
        sorting.clickNameAsc();
    }

    @Override
    public void changeSortingNameDesc() {
        LOGGER.info("changeSortingNameDesc()");
        sortButton.click();
        sorting.clickNameDesc();
    }

    @Override
    public void changeSortingPriceAsc() {
        LOGGER.info("changeSortingPriceAsc()");
        sortButton.click();
        sorting.clickPriceAsc();
    }

    @Override
    public void changeSortingPriceDesc() {
        LOGGER.info("changeSortingPriceDesc()");
        sortButton.click();
        sorting.clickPriceDesc();
    }

    @Override
    public String getFirstProductDescription() {
        LOGGER.info("getFirstProductDescription()");
        return products.getFirst().getProductAttributes().getFirst().getAttribute("name");
    }

    @Override
    public String getLastProductDescription() {
        LOGGER.info("getLastProductDescription()");
        return products.getLast().getProductAttributes().getFirst().getAttribute("name");
    }

    @Override
    public MenuPageBase clickMoreButton() {
        LOGGER.info("clickMoreButton()");
        return header.openMenu();
    }

    @Override
    public CatalogPageBase clickCatalogButton() {
        return null;
    }

    @Override
    public CartPageBase clickCartButton() {
        return null;
    }

}
