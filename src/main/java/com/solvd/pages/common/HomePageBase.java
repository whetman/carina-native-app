package com.solvd.pages.common;

import com.solvd.components.Header;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class HomePageBase extends AbstractPage implements IMobileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageBase.class);

    //xpath to be changed!
    @FindBy(xpath = "//android.view.View[@text=\"Nagłówek\"]/android.view.View/android.view.View/android.view.View[2]")
    private Header header;

    @FindBy(className = "android.widget.Image")
    private ExtendedWebElement iconLogo;

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(this.iconLogo);
    }

    public Header getHeader() {
        return header;
    }

    public ExtendedWebElement getIconLogo() {
        waitUntil(elementToBeClickable(this.iconLogo), 10);
        return iconLogo;
    }
}
