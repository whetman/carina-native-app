package com.solvd.demoapp.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GeoLocationPageBase extends PageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(GeoLocationPageBase.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[7]")
    private ExtendedWebElement longitude;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[8]")
    private ExtendedWebElement latitude;

    public GeoLocationPageBase(WebDriver driver) {
        super(driver);
    }

    public String getLongitude() {
        LOGGER.info("getLongitude(" + longitude.getText() + ")");
        return longitude.getText();
    }

    public String getLatitude() {
        LOGGER.info("getLatitude(" + latitude.getText() + ")");
        return latitude.getText();
    }
}
