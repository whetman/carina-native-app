package com.solvd.swaglabs.pages.ios;

import com.solvd.swaglabs.pages.common.AllItemsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AllItemsPageBase.class)
public class AllItemsPage extends AllItemsPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(AllItemsPage.class);

    public AllItemsPage(WebDriver driver) {
        super(driver);
        LOGGER.info("AllItemsPage()");
    }
}
