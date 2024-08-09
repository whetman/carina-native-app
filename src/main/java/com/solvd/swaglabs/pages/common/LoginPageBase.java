package com.solvd.swaglabs.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public abstract class LoginPageBase extends PageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPageBase.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField")
    private ExtendedWebElement usernameField;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeSecureTextField")
    private ExtendedWebElement passwordField;

    @ExtendedFindBy(iosPredicate = "name == \"test-LOGIN\"")
    private ExtendedWebElement loginButton;

    public LoginPageBase(WebDriver driver) {
        super(driver);
        LOGGER.info("LoginPageBase");
        setUiLoadedMarker(loginButton);
    }

}
