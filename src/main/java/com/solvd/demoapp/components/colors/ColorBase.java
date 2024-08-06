package com.solvd.demoapp.components.colors;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

@Getter
public abstract class ColorBase extends AbstractUIObject {

    public ColorBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

}
