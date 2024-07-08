package com.solvd.pages.common;

import com.solvd.components.Header;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class HomePageBase extends AbstractPage implements IMobileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageBase.class);

    //xpath to be changed?
    @FindBy(xpath = "//android.view.View[@text=\"Nagłówek\"]")
    private Header header;

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(this.header);
    }

    public Header getHeader() {
        waitUntil(elementToBeClickable(this.header), 30);
        return header;
    }

}
