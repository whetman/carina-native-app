package com.solvd.demoapp.pages.common;

import com.solvd.demoapp.pages.ios.SauceLabs;
import com.zebrunner.carina.utils.ios.IOSUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SauceLabsBase extends AbstractPage implements IOSUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(SauceLabs.class);

    public SauceLabsBase(WebDriver driver) {
        super(driver);
        LOGGER.info("SauceLabsBase()");
    }
}
