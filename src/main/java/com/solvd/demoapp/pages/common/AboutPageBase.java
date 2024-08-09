package com.solvd.demoapp.pages.common;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AboutPageBase extends PageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(AboutPageBase.class);

    public AboutPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SauceLabsBase goToSauceLabsPage();

}
