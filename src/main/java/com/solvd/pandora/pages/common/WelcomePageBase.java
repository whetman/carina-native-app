package com.solvd.pandora.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class WelcomePageBase extends PageBase{

    private static final Logger LOGGER = LoggerFactory.getLogger(WelcomePageBase.class);

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'DZIEŃ DOBRY')]")
    private ExtendedWebElement welcomeMessage;

    public WelcomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(this.welcomeMessage);
    }
}
