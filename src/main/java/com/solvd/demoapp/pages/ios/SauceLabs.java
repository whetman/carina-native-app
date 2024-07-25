package com.solvd.demoapp.pages.ios;

import com.solvd.demoapp.pages.common.SauceLabsBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SauceLabsBase.class)
public class SauceLabs extends SauceLabsBase {

    public SauceLabs(WebDriver driver) {
        super(driver);
    }
}
