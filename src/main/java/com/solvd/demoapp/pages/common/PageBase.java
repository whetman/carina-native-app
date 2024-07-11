package com.solvd.demoapp.pages.common;

import com.solvd.demoapp.components.common.FooterBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PageBase extends AbstractPage implements IMobileUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(PageBase.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"Catalog-screen\"`]/XCUIElementTypeOther[5]/XCUIElementTypeOther")
    private FooterBase footer;

    public PageBase(WebDriver driver) {
        super(driver);
    }


//    public PageBase(WebDriver driver) {
//        super(driver);
//        this.footer = footer;
//    }

    public FooterBase getFooter() {
        return footer;
    }
}
