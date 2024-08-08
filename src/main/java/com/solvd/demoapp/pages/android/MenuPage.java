package com.solvd.demoapp.pages.android;

import com.solvd.demoapp.pages.common.AboutPageBase;
import com.solvd.demoapp.pages.common.CartPageBase;
import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.solvd.demoapp.pages.common.DrawingPageBase;
import com.solvd.demoapp.pages.common.GeoLocationPageBase;
import com.solvd.demoapp.pages.common.LoginPageBase;
import com.solvd.demoapp.pages.common.MenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * this page on Android looks like a component but works only as a page
 * there is no logout option on Android :)
 */
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MenuPageBase.class)
public class MenuPage extends MenuPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuPage.class);

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemTV\" and @text=\"Log In\"]")
    private ExtendedWebElement loginOption;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemTV\" and @text=\"Drawing\"]")
    private ExtendedWebElement drawingButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemTV\" and @text=\"About\"]")
    private ExtendedWebElement aboutButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemTV\" and @text=\"Geo Location\"]")
    private ExtendedWebElement geoLocationButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemTV\" and @text=\"Reset App State\"]")
    private ExtendedWebElement resetButton;

    @FindBy(id = "android:id/button1")
    private ExtendedWebElement resetButtonInWindow;

    @FindBy(id = "android:id/button1")
    protected ExtendedWebElement okButton;

    public MenuPage(WebDriver driver) {
        super(driver);
        LOGGER.info("MenuPage()");
        setUiLoadedMarker(loginOption);
    }

    @Override
    public LoginPageBase goToLoginPage() {
        LOGGER.info("goToLoginPage()");
        loginOption.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public DrawingPageBase clickDrawingButton() {
        LOGGER.info("clickDrawingButton()");
        drawingButton.click();
        return initPage(getDriver(), DrawingPageBase.class);
    }

    @Override
    public AboutPageBase clickAboutButton() {
        LOGGER.info("clickAboutButton()");
        aboutButton.click();
        return initPage(getDriver(), AboutPageBase.class);
    }

    @Override
    public GeoLocationPageBase clickGeoLocationButton() {
        LOGGER.info("clickGeoLocationButton()");
        geoLocationButton.click();
        return initPage(getDriver(), GeoLocationPageBase.class);
    }

    @Override
    public MenuPageBase resetApplication(){
        LOGGER.info("resetApplication()");
        resetButton.click();
        resetButtonInWindow.click();
        okButton.click();
        return initPage(getDriver(), MenuPageBase.class);
    }

    @Override
    public ExtendedWebElement getLogoutButton() {
        return null;
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
