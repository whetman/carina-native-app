package com.solvd.demoapp.pages.ios;

import com.solvd.demoapp.pages.common.GeoLocationPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = GeoLocationPageBase.class)
public class GeoLocationPage extends GeoLocationPageBase {

    public GeoLocationPage(WebDriver driver) {
        super(driver);
    }
}
