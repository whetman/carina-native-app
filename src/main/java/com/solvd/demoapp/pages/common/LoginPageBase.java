package com.solvd.demoapp.pages.common;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LoginPageBase extends PageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPageBase.class);

    public LoginPageBase(WebDriver driver) {
        super(driver);
        LOGGER.info("LoginPageBase()");
    }

    public abstract CatalogPageBase loginBob();
}
