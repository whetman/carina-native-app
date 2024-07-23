package com.solvd.demoapp.pages.common;

import com.zebrunner.carina.utils.ios.IOSUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PageBase extends AbstractPage implements IOSUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(PageBase.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Catalog-tab-item\"`]")
    private ExtendedWebElement catalogButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Cart-tab-item\"`]")
    private ExtendedWebElement cartButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"More-tab-item\"`]")
    private ExtendedWebElement moreButton;

    public PageBase(WebDriver driver) {
        super(driver);
    }

    public CatalogPageBase clickCatalogButton(){
        LOGGER.info("clickCatalogButton()");
        catalogButton.click();
        return initPage(getDriver(), CatalogPageBase.class);
    }

    public void clickCartButton(){
        LOGGER.info("clickCartButton()");
        cartButton.click();
    }

    public RightMenuPageBase clickMoreButton(){
        LOGGER.info("clickMoreButton()");
        moreButton.click();
        return initPage(getDriver(), RightMenuPageBase.class);
    }

    public ExtendedWebElement getCatalogButton() {
        return catalogButton;
    }

    public ExtendedWebElement getCartButton() {
        return cartButton;
    }

    public ExtendedWebElement getMoreButton() {
        return moreButton;
    }

}
