package com.solvd.pandora.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(xpath = "//android.widget.Button[@text=\"Zaloguj się i kontynuuj\"]")
    private ExtendedWebElement loggingButton;

    public MyAccountPageBase(WebDriver driver) {
        super(driver);
    }

    public WelcomePageBase login(String email, String password) {
        LOGGER.info("login(" + email + ", " + password + ")");

        LOGGER.info("email field: " + emailField.isVisible());
        waitUntil(elementToBeClickable(this.emailField), 60);
        LOGGER.info("email field: " + emailField.isVisible());

        LOGGER.info("password field: " + passwordField.isVisible());
        waitUntil(elementToBeClickable(this.passwordField), 60);
        LOGGER.info("password field: " + passwordField.isVisible());

        //for some reason this is the only way I can type email
        emailField.click();
        Actions action = new Actions(getDriver());
        action.sendKeys(email);
        action.perform();
        passwordField.click();
        passwordField.type(password);

        //to hide the keyboard
        tap(42, 908);

        loggingButton.click();

        return initPage(getDriver(), WelcomePageBase.class);
    }

    public ExtendedWebElement getEmailField() {
        return emailField;
    }

    public ExtendedWebElement getPasswordField() {
        return passwordField;
    }

    public ExtendedWebElement getLoggingButton() {
        return loggingButton;
    }
}
