package com.solvd.pandora.pages.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class HomePageBase extends PageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageBase.class);

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(getHeader());
    }

}
