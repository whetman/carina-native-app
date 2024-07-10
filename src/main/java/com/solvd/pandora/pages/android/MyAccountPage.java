package com.solvd.pandora.pages.android;

import com.solvd.pandora.pages.common.MyAccountPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MyAccountPageBase.class)
public class MyAccountPage extends MyAccountPageBase {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
}
