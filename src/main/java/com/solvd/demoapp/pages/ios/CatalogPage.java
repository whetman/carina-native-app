package com.solvd.demoapp.pages.ios;

import com.solvd.demoapp.components.header.Header;
import com.solvd.demoapp.components.product.ProductIOS;
import com.solvd.demoapp.components.sorting.SortingIOS;
import com.solvd.demoapp.pages.common.CartPageBase;
import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.solvd.demoapp.pages.common.MenuPageBase;
import com.solvd.demoapp.pages.common.ProductPageBase;
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
@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CatalogPageBase.class)
public class CatalogPage extends CatalogPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogPage.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"Catalog-screen\"`]")
    private ExtendedWebElement catalogScreen;

    @ExtendedFindBy(iosPredicate = "name == \"ProductItem\"")
    private List<ProductIOS> products;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Button\"`]")
    private ExtendedWebElement sortButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[$type == 'XCUIElementTypeButton' AND name == 'Name - Ascending'$][-1]")
    private SortingIOS sortingIOS;

    @ExtendedFindBy(accessibilityId = "More-tab-item")
    private ExtendedWebElement moreButton;

    @ExtendedFindBy(accessibilityId = "OK")
    protected ExtendedWebElement okButton;

    public CatalogPage(WebDriver driver) {
        super(driver);
        LOGGER.info("CatalogPage()");
        setUiLoadedMarker(catalogScreen);
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
        ProductIOS product = products.get(index);
        product.rateProduct();
        return okButton;
    }

    @Override
    public void changeSortingNameAsc() {
        LOGGER.info("changeSortingNameAsc()");
        sortButton.click();
        sortingIOS.clickNameAsc();
    }

    @Override
    public void changeSortingNameDesc() {
        LOGGER.info("changeSortingNameDesc()");
        sortButton.click();
        sortingIOS.clickNameDesc();
    }

    @Override
    public void changeSortingPriceAsc() {
        LOGGER.info("changeSortingPriceAsc()");
        sortButton.click();
        sortingIOS.clickPriceAsc();
    }

    @Override
    public void changeSortingPriceDesc() {
        LOGGER.info("changeSortingPriceDesc()");
        sortButton.click();
        sortingIOS.clickPriceDesc();
    }

    @Override
    public MenuPageBase clickMoreButton() {
        LOGGER.info("clickMoreButton()");
        moreButton.click();
        return initPage(getDriver(), MenuPageBase.class);
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
    public Header getHeader() {
        return null;
    }
}
