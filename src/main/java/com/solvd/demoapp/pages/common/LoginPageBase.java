package com.solvd.demoapp.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LoginPageBase extends PageBase{
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPageBase.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Login\"`]")
    private ExtendedWebElement loginButton;

    //todo change locator if possible
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]")
    private ExtendedWebElement userNameField;

    //todo change locator if possible
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeSecureTextField")
    private ExtendedWebElement passwordField;

    public LoginPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(this.loginButton);
    }

    public void logIn(String username, String password){
        userNameField.type(username);
        passwordField.type(password);

        LOGGER.info("KEYBOARD: " + isKeyboardShown() );

        hideKeyboard();
        LOGGER.info("KEYBOARD: " + isKeyboardShown() );

        loginButton.click();
    }

}
