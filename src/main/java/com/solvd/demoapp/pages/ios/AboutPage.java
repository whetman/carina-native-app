package com.solvd.demoapp.pages.ios;

import com.solvd.demoapp.pages.common.AboutPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AboutPageBase.class)
public class AboutPage extends AboutPageBase {
    public AboutPage(WebDriver driver) {
        super(driver);
    }
}
