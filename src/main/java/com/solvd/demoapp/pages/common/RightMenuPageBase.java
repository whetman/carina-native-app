package com.solvd.demoapp.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public abstract class RightMenuPageBase extends PageBaseWithOkButton {
    private static final Logger LOGGER = LoggerFactory.getLogger(RightMenuPageBase.class);

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

    public RightMenuPageBase(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginOption);
    }

    public LoginPageBase goToLoginPage() {
        LOGGER.info("goToLoginPage()");
        loginOption.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

    public DrawingPageBase clickDrawingButton() {
        LOGGER.info("clickDrawingButton()");
        drawingButton.click();
        return initPage(getDriver(), DrawingPageBase.class);
    }

    public AboutPageBase clickAboutButton() {
        LOGGER.info("clickAboutButton()");
        aboutButton.click();
        return initPage(getDriver(), AboutPageBase.class);
    }

    public GeoLocationPageBase clickGeoLocationButton() {
        LOGGER.info("clickGeoLocationButton()");
        geoLocationButton.click();
        return initPage(getDriver(), GeoLocationPageBase.class);
    }

    public RightMenuPageBase resetApplication(){
        LOGGER.info("resetApplication()");
        resetButton.click();
        resetButtonInWindow.click();
        okButton.click();
        return initPage(getDriver(), RightMenuPageBase.class);
    }
}
