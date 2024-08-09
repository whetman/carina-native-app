package com.solvd.demoapp.pages.android;

import com.solvd.demoapp.pages.common.SauceLabsBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SauceLabsBase.class)
public class SauceLabs extends SauceLabsBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(SauceLabs.class);

    @FindBy(xpath = "//android.widget.Image[@text=\"Saucelabs\"]")
    private ExtendedWebElement logo;

    public SauceLabs(WebDriver driver) {
        super(driver);
        LOGGER.info("SauceLabs()");
        setUiLoadedMarker(logo);
    }

}
