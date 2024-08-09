package com.solvd.demoapp.pages.common;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GeoLocationPageBase extends PageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(GeoLocationPageBase.class);

    public GeoLocationPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getLongitude();

    public abstract String getLatitude();
}
