package com.solvd.pandora.pages.common;

import com.solvd.pandora.components.android.Header;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PageBase extends AbstractPage implements IMobileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(PageBase.class);

    //xpath to be changed?
    @FindBy(xpath = "//android.view.View[@text=\"Nagłówek\"]")
    private Header header;

    public PageBase(WebDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        LOGGER.info("getHeader()");
        return header;
    }
}
