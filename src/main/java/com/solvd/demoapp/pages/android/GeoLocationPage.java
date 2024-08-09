package com.solvd.demoapp.pages.android;

import com.solvd.demoapp.pages.common.CartPageBase;
import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.solvd.demoapp.pages.common.GeoLocationPageBase;
import com.solvd.demoapp.pages.common.MenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = GeoLocationPageBase.class)
public class GeoLocationPage extends GeoLocationPageBase{
    private static final Logger LOGGER = LoggerFactory.getLogger(GeoLocationPage.class);

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/longitudeTV")
    private ExtendedWebElement longitude;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/latitudeTV")
    private ExtendedWebElement latitude;

    public GeoLocationPage(WebDriver driver) {
        super(driver);
        LOGGER.info("GeoLocationPage()");
    }

    @Override
    public String getLongitude() {
        LOGGER.info("getLongitude(" + longitude.getText() + ")");
        return longitude.getText();
    }

    @Override
    public String getLatitude() {
        LOGGER.info("getLatitude(" + latitude.getText() + ")");
        return latitude.getText();
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