package com.solvd.demoapp.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AboutPageBase extends PageBase{
    private static final Logger LOGGER = LoggerFactory.getLogger(AboutPageBase.class);

    @ExtendedFindBy(iosPredicate = "About ")
    private ExtendedWebElement pageTitle;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Go to saucelabs.com\"`]")
    private ExtendedWebElement link;

    public AboutPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(this.pageTitle);
    }

    public SauceLabsBase goToSauceLabsPage(){
        LOGGER.info("goToSauceLabsPage()");
        link.click();
        return initPage(getDriver(), SauceLabsBase.class);
    }

}
