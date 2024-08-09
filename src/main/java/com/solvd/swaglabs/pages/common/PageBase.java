package com.solvd.swaglabs.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PageBase extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(PageBase.class);

    public PageBase(WebDriver driver) {
        super(driver);
        LOGGER.info("PageBase()");
    }
}
