package com.solvd.demoapp.pages.android;

import com.solvd.demoapp.pages.common.AboutPageBase;
import com.solvd.demoapp.pages.common.CartPageBase;
import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.solvd.demoapp.pages.common.MenuPageBase;
import com.solvd.demoapp.pages.common.SauceLabsBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AboutPageBase.class)
public class AboutPage extends AboutPageBase{
    private static final Logger LOGGER = LoggerFactory.getLogger(AboutPage.class);

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/aboutTV")
    private ExtendedWebElement pageTitle;

    @ExtendedFindBy(accessibilityId = "Tap to view content of given url")
    private ExtendedWebElement link;

    public AboutPage(WebDriver driver) {
        super(driver);
        LOGGER.info("AboutPage()");
        setUiLoadedMarker(pageTitle);
    }

    @Override
    public SauceLabsBase goToSauceLabsPage(){
        LOGGER.info("goToSauceLabsPage()");
        link.click();
        return initPage(getDriver(), SauceLabsBase.class);
    }

    @Override
    public CatalogPageBase clickCatalogButton() {
        return null;
    }

    @Override
    public CartPageBase clickCartButton() {
        return null;
    }

    @Override
    public MenuPageBase clickMoreButton() {
        return null;
    }
}
