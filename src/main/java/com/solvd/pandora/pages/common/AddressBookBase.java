package com.solvd.pandora.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AddressBookBase extends PageBase{

    @FindBy(xpath = "//android.widget.TextView[@text=\"ADRESY\"]")
    private ExtendedWebElement addressBookTitle;

    public AddressBookBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(this.addressBookTitle);
    }
}
