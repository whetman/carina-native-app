package com.solvd.demoapp.pages.ios;

import com.solvd.demoapp.pages.common.AboutPageBase;
import com.solvd.demoapp.pages.common.CartPageBase;
import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.solvd.demoapp.pages.common.DrawingPageBase;
import com.solvd.demoapp.pages.common.GeoLocationPageBase;
import com.solvd.demoapp.pages.common.LoginPageBase;
import com.solvd.demoapp.pages.common.MenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MenuPageBase.class)
public class MenuPage extends MenuPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuPage.class);

    @ExtendedFindBy(iosPredicate = "name == \"LogOut-menu-item\"")
    private ExtendedWebElement loginOption;

    @ExtendedFindBy(accessibilityId = "Drawing-menu-item")
    private ExtendedWebElement drawingButton;

    @ExtendedFindBy(accessibilityId = "About-menu-item")
    private ExtendedWebElement aboutButton;

    @ExtendedFindBy(accessibilityId = "GeoLocation-menu-item")
    private ExtendedWebElement geoLocationButton;

    @ExtendedFindBy(accessibilityId = "ResetAppState-menu-item")
    private ExtendedWebElement resetButton;

    @ExtendedFindBy(accessibilityId = "RESET APP")
    private ExtendedWebElement resetButtonInWindow;

    @ExtendedFindBy(accessibilityId = "LogOut-menu-item")
    private ExtendedWebElement logoutButton;

    @ExtendedFindBy(accessibilityId = "OK")
    protected ExtendedWebElement okButton;

    public MenuPage(WebDriver driver) {
        super(driver);
        LOGGER.info("RightMenuPage()");
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
    public boolean resetApplication(){
        LOGGER.info("resetApplication()");
        resetButton.click();
        resetButtonInWindow.click();
        return okButton.clickIfPresent();
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
