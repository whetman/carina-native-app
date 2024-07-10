package com.solvd.pandora.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public abstract class MyAccountPageBase extends PageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyAccountPageBase.class);

    @FindBy(xpath = "(//android.view.View[@text=\"ZALOGUJ SIĘ\"])[2]/android.view.View[1]/android.view.View[1]")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "(//android.view.View[@text=\"ZALOGUJ SIĘ\"])[2]/android.view.View[1]/android.view.View[2]/android.view.View/android.widget.EditText")
    private ExtendedWebElement passwordField;

    public MyAccountPageBase(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        LOGGER.info("login(" + email + ", " + password + ")");

        waitUntil(elementToBeClickable(this.emailField), 60);
        waitUntil(elementToBeClickable(this.passwordField), 60);

        emailField.type(email);
        passwordField.type(password);
    }

    public ExtendedWebElement getEmailField() {
        LOGGER.info("getEmailField()");
        return emailField;
    }

    public ExtendedWebElement getPasswordField() {
        LOGGER.info("getPasswordField()");
        return passwordField;
    }
}
