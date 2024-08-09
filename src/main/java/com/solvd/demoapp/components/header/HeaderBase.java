package com.solvd.demoapp.components.header;

import com.solvd.demoapp.components.sorting.SortingAndroid;
import com.solvd.demoapp.pages.common.MenuPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public abstract class HeaderBase extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(HeaderBase.class);

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/menuIV")
    private ExtendedWebElement menuButton;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/sortIV")
    private SortingAndroid sorting;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    private ExtendedWebElement cartButton;

    public HeaderBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        LOGGER.info("HeaderBase");
    }

    public MenuPageBase openMenu(){
        LOGGER.info("openMenu()");
        menuButton.click();
        return initPage(getDriver(), MenuPageBase.class);
    }

}
