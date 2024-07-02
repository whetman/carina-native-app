package com.solvd.pages.common;

import com.solvd.util.MobileContextUtils;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePageBase extends AbstractPage implements IMobileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageBase.class);

    @FindBy(xpath = "//android.webkit.WebView")
    private ExtendedWebElement element;

    @FindBy(xpath = "//*[@id=\"screenshotContainer\"]/div[2]/div/div/div/div/div[72]")
//    @FindBy(className = "android.widget.Button")
    private ExtendedWebElement agreementButton;

    public HomePageBase(WebDriver driver) {
        super(driver);
        MobileContextUtils mobileContextUtils = new MobileContextUtils();
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    @Override
    public boolean isPageOpened() {
        return element.isDisplayed();
    }

    public ExtendedWebElement getElement() {
        return element;
    }

    public ExtendedWebElement getAgreementButton() {
//        MobileContextUtils mobileContextUtils = new MobileContextUtils();
//        mobileContextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);
        waitUntil(visibilityOf(agreementButton), Duration.ofSeconds(30L));
        return agreementButton;
    }
}
