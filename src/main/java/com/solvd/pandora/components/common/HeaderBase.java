package com.solvd.pandora.components.common;

import com.solvd.pandora.pages.common.MyAccountPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public abstract class HeaderBase extends AbstractUIObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(HeaderBase.class);

    @FindBy(xpath = "//android.widget.Button[@text=\"Zaloguj się na swoje konto\"]")
    private ExtendedWebElement loginButton;

    public HeaderBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public MyAccountPageBase clickLoginButton(){
        LOGGER.info("login()");
        LOGGER.info("1. LOGIN BUTTON: " + loginButton.isVisible());
        waitUntil(elementToBeClickable(this.loginButton), 90);
        LOGGER.info("2. LOGIN BUTTON 2: " + loginButton.isVisible());
        loginButton.click();
        return initPage(getDriver(), MyAccountPageBase.class);
    }

    public ExtendedWebElement getLoginButton() {
        return loginButton;
    }
}
