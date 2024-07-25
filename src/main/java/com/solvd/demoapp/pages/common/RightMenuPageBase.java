package com.solvd.demoapp.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public abstract class RightMenuPageBase extends PageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(RightMenuPageBase.class);

    @ExtendedFindBy(iosPredicate = "name == \"LogOut-menu-item\"")
    private ExtendedWebElement loginOption;

    public RightMenuPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(this.loginOption);
    }

    public LoginPageBase goToLoginPage() {
        LOGGER.info("goToLoginPage()");
        loginOption.click();
        return initPage(getDriver(), LoginPageBase.class);
    }
}
