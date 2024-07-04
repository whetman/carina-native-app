package com.solvd.pages.common;

import com.solvd.components.AgreementWindow;
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

    @FindBy(xpath = "((//android.view.View[@text=\"Dbamy o Twoją prywatność\"])[2]/android.view.View[2]")
    private AgreementWindow agreementWindow;

//    @FindBy(className = "_highlighter-box86d92 _inspected-element-box86d92")
//    @FindBy(xpath = "//*[@id=\"screenshotContainer\"]/div[2]/div/div/div/div/div[72]")
//    @FindBy(xpath = "//android.widget.Button[@text=\"Zgoda i kontynuacja\"]")
//    @FindBy()
    private ExtendedWebElement agreementButton;

    @FindBy(xpath = "(//android.view.View[@text=\"Dbamy o Twoją prywatność\"])[2]/android.view.View[1]")
    private ExtendedWebElement agreementMessage;

    public HomePageBase(WebDriver driver) {
        super(driver);
        MobileContextUtils mobileContextUtils = new MobileContextUtils();
//        mobileContextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    @Override
    public boolean isPageOpened() {
        return element.isDisplayed();
//        return agreementButton.isDisplayed();
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

    public ExtendedWebElement getAgreementMessage() {
        return agreementMessage;
    }

    public AgreementWindow getAgreementWindow() {
        return agreementWindow;
    }
}
