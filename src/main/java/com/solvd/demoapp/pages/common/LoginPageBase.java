package com.solvd.demoapp.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LoginPageBase extends PageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPageBase.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Login\"`]")
    private ExtendedWebElement loginButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == \"bob@example.com\"`]")
    private ExtendedWebElement bobLoginButton;

    public LoginPageBase(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginButton);
    }

    public CatalogPageBase loginBob(){
        LOGGER.info("loginBob()");
        bobLoginButton.click();
        loginButton.click();
        return initPage(getDriver(), CatalogPageBase.class);
    }

}
