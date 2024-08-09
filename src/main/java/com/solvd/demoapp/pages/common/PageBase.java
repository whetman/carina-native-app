package com.solvd.demoapp.pages.common;

import com.zebrunner.carina.utils.ios.IOSUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PageBase extends AbstractPage implements IOSUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(PageBase.class);

    public PageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CatalogPageBase clickCatalogButton();

    public abstract CartPageBase clickCartButton();

    public abstract MenuPageBase clickMoreButton();
}
