package com.solvd.demoapp.components.colors;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

/**
 * Each color has unique locator, so I can't make a List of them
 */
@Getter
public class ColorBase extends AbstractUIObject {

    @ExtendedFindBy(accessibilityId = "GreenColorUnSelected Icons")
    private ExtendedWebElement colorGreen;

    @ExtendedFindBy(accessibilityId = "BlueColorUnSelected Icons")
    private ExtendedWebElement colorBlue;

    @ExtendedFindBy(accessibilityId = "BlackColorUnSelected Icons")
    private ExtendedWebElement colorBlack;

    @ExtendedFindBy(accessibilityId = "GrayColorUnSelected Icons")
    private ExtendedWebElement colorGray;

    public ColorBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

}
