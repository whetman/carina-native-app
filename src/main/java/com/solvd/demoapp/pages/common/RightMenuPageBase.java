package com.solvd.demoapp.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public abstract class RightMenuPageBase extends PageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(RightMenuPageBase.class);

    @ExtendedFindBy(iosPredicate = "name == \"LogOut-menu-item\"")
    private ExtendedWebElement loginOption;

    @ExtendedFindBy(accessibilityId = "Drawing-menu-item")
    private ExtendedWebElement drawingButton;

    @ExtendedFindBy(accessibilityId = "About-menu-item")
    private ExtendedWebElement aboutButton;

    @ExtendedFindBy(accessibilityId = "GeoLocation-menu-item")
    private ExtendedWebElement geoLocationButton;

    public RightMenuPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(this.loginOption);
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
}
