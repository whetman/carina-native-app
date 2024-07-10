package com.solvd.pandora.pages.android;

import com.solvd.pandora.pages.common.AddressBookBase;
import com.solvd.pandora.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class AddressBook extends AddressBookBase {
    public AddressBook(WebDriver driver) {
        super(driver);
    }
}
