package com.solvd.pandora.pages.android;

import com.solvd.pandora.pages.common.WelcomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {
    public WelcomePage(WebDriver driver) {
        super(driver);
    }
}
