package com.solvd.demoapp.pages.ios;

import com.solvd.demoapp.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductPage.class);
    public ProductPage(WebDriver driver) {
        super(driver);
    }
}
