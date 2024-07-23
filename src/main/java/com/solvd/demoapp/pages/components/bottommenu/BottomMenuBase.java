package com.solvd.demoapp.pages.components.bottommenu;

import com.solvd.demoapp.pages.common.CartPageBase;
import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.solvd.demoapp.pages.common.RightMenuPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BottomMenuBase extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(BottomMenuBase.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Catalog-tab-item\"`]")
    private ExtendedWebElement catalogButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Cart-tab-item\"`]")
    private ExtendedWebElement cartButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"More-tab-item\"`]")
    private ExtendedWebElement moreButton;

    public BottomMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CatalogPageBase clickCatalogButton(){
        LOGGER.info("clickCatalogButton()");
        catalogButton.click();
        return initPage(getDriver(), CatalogPageBase.class);
    }

    public CartPageBase clickCartButton(){
        LOGGER.info("clickCartButton()");
        cartButton.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    public RightMenuPageBase clickMoreButton(){
        LOGGER.info("clickMoreButton()");
        moreButton.click();
        return initPage(getDriver(), RightMenuPageBase.class);
    }
}
