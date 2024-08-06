package com.solvd.demoapp.components.rating;

import com.solvd.demoapp.utils.RandomIndex;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class RatingBase extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(RatingBase.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"StarSelected Icons\"`]")
    private List<ExtendedWebElement> selectedStars;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"StarUnSelected Icons\"`]")
    private List<ExtendedWebElement> unselectedStars;

    public RatingBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickRandomSelectedStar() {
        LOGGER.info("clickSelectedStar()");
        if (!selectedStars.isEmpty()) {
            int index = RandomIndex.randomize(selectedStars.size());
            LOGGER.info("Clicking " + index + " selected star");
            selectedStars.get(index).click();
        } else {
            LOGGER.info("No selected stars to be clicked");
        }
    }

    public void clickUnselectedStar() {
        LOGGER.info("clickUnselectedStar()");
        if (!unselectedStars.isEmpty()) {
            int index = RandomIndex.randomize(unselectedStars.size());
            LOGGER.info("Clicking " + index + " unselected star");
            unselectedStars.get(index).click();
        } else {
            LOGGER.info("No unselected stars to be clicked");
        }
    }
}
