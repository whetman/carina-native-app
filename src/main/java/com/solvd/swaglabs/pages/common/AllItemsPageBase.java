package com.solvd.swaglabs.pages.common;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllItemsPageBase extends PageBase{
    private static final Logger LOGGER = LoggerFactory.getLogger(AllItemsPageBase.class);

    public AllItemsPageBase(WebDriver driver) {
        super(driver);
        LOGGER.info("AllItemsPageBase");
    }
}
