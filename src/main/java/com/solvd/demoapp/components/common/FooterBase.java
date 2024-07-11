package com.solvd.demoapp.components.common;

import com.solvd.demoapp.pages.common.RightMenuPageBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class FooterBase extends AbstractUIObject implements IMobileUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(FooterBase.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Catalog-tab-item\"`]")
    private ExtendedWebElement catalogButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Cart-tab-item\"`]")
    private ExtendedWebElement cartButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"More-tab-item\"`]")
    private ExtendedWebElement moreButton;

    public FooterBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        LOGGER.info("FooterBase()");
    }

    public RightMenuPageBase goToRightMenuPage(){
        moreButton.click();
        return initPage(getDriver(), RightMenuPageBase.class);
    }


}
