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

    @ExtendedFindBy(accessibilityId = "Catalog-tab-item")
    private ExtendedWebElement catalogButton;

    @ExtendedFindBy(accessibilityId = "Cart-tab-item")
    private ExtendedWebElement cartButton;

    @ExtendedFindBy(accessibilityId = "More-tab-item")
    private ExtendedWebElement moreButton;

    public PageBase(WebDriver driver) {
        super(driver);
    }

    public CatalogPageBase clickCatalogButton() {
        LOGGER.info("clickCatalogButton()");
        catalogButton.click();
        return initPage(getDriver(), CatalogPageBase.class);
    }

    public CartPageBase clickCartButton() {
        LOGGER.info("clickCartButton()");
        cartButton.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    public RightMenuPageBase clickMoreButton() {
        LOGGER.info("clickMoreButton()");
        moreButton.click();
        return initPage(getDriver(), RightMenuPageBase.class);
    }
}
