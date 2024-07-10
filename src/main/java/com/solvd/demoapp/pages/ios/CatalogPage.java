package com.solvd.demoapp.pages.ios;

import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CatalogPageBase.class)
public class CatalogPage extends CatalogPageBase {
    public CatalogPage(WebDriver driver) {
        super(driver);
    }
}
