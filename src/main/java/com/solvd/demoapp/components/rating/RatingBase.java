package com.solvd.demoapp.components.rating;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class RatingBase extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(RatingBase.class);

    public RatingBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        LOGGER.info("RatingBase()");
    }

    public abstract void clickRandomSelectedStar();

    public abstract void clickUnselectedStar();

    public abstract void clickRandomStar();
}
