package com.solvd.demoapp.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public abstract class MenuPageBase extends PageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuPageBase.class);

    public MenuPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract LoginPageBase goToLoginPage();

    public abstract DrawingPageBase clickDrawingButton();

    public abstract AboutPageBase clickAboutButton();

    public abstract GeoLocationPageBase clickGeoLocationButton();

    public abstract boolean resetApplication();

    public abstract ExtendedWebElement getLogoutButton();
}
