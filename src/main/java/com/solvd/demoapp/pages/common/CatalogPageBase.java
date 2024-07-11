package com.solvd.demoapp.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CatalogPageBase extends PageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogPageBase.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"Catalog-screen\"`]")
    private ExtendedWebElement catalogScreen;

    public CatalogPageBase(WebDriver driver) {
        super(driver);
        LOGGER.info("CatalogPageBase()");
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(this.catalogScreen);
    }

    public ExtendedWebElement getCatalogScreen() {
        return catalogScreen;
    }
}
