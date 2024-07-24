package com.solvd.demoapp.components.colors;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

//todo fix - make a list if possible
@Getter
public abstract class ColorBase extends AbstractUIObject {

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
