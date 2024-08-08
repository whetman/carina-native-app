package com.solvd.demoapp.pages.ios;

import com.solvd.demoapp.pages.common.SauceLabsBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SauceLabsBase.class)
public class SauceLabs extends SauceLabsBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(SauceLabs.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeImage[`name == \"Saucelabs\"`]")
    private ExtendedWebElement logo;

    public SauceLabs(WebDriver driver) {
        super(driver);
        LOGGER.info("SauceLabs()");
        setUiLoadedMarker(logo);
    }
}
