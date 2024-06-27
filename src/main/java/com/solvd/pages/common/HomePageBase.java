package com.solvd.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePageBase extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageBase.class);

    public HomePageBase(WebDriver driver) {
        super(driver);
    }


}
