package com.solvd.demoapp.components.header;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Header extends HeaderBase{
    private static final Logger LOGGER = LoggerFactory.getLogger(HeaderBase.class);

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        LOGGER.info("Header");
    }
}
