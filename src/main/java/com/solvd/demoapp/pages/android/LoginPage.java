package com.solvd.demoapp.pages.android;

import com.solvd.demoapp.pages.common.CartPageBase;
import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.solvd.demoapp.pages.common.LoginPageBase;
import com.solvd.demoapp.pages.common.MenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase{
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

    @ExtendedFindBy(accessibilityId = "Tap to login with given credentials")
    private ExtendedWebElement loginButton;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/username1TV")
    private ExtendedWebElement bobLoginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        LOGGER.info("LoginPage()");
        setUiLoadedMarker(loginButton);
    }

    @Override
    public CatalogPageBase loginBob(){
        LOGGER.info("loginBob()");
        bobLoginButton.click();
        loginButton.click();
        return initPage(getDriver(), CatalogPageBase.class);
    }

    @Override
    public CatalogPageBase clickCatalogButton() {
        return null;
    }

    @Override
    public CartPageBase clickCartButton() {
        return null;
    }

    @Override
    public MenuPageBase clickMoreButton() {
        return null;
    }
}
