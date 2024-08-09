package com.solvd.demoapp.components.rating;

import com.solvd.demoapp.utils.RandomIndex;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RatingAndroid extends RatingBase{
    private static final Logger LOGGER = LoggerFactory.getLogger(RatingAndroid.class);

    @FindBy(xpath = ".//android.widget.ImageView[contains(@resource-id, \"com.saucelabs.mydemoapp.android:id/start\")]")
    private List<ExtendedWebElement> stars;

    public RatingAndroid(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        LOGGER.info("RatingAndroid()");
    }

    @Override
    public void clickRandomStar() {
        LOGGER.info("clickRandomStar()");
        LOGGER.info("SIZE: " + stars.size());
        int index = RandomIndex.randomize(stars.size());
        LOGGER.info("clickRandomStar({})", index);
        stars.get(index).click();
    }

    public void clickRandomSelectedStar() {}

    public void clickUnselectedStar() {}

}
