package com.solvd.demoapp.pages.common;

import com.zebrunner.carina.utils.ios.IOSUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

public abstract class SauceLabsBase extends AbstractPage implements IOSUtils {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeImage[`name == \"Saucelabs\"`]")
    private ExtendedWebElement logo;

    public SauceLabsBase(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logo);
    }
}
