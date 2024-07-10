package com.solvd.tests;

import com.zebrunner.carina.core.IAbstractTest;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;

public abstract class AbstractTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTest.class);

    private WebDriver driver;

//    public MyAccountPageBase login(String login, String password){
//        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
//        MyAccountPageBase myAccountPage = homePage.getHeader().login();
////        MyAccountPageBase myAccountPageLooged = myAccountPage.login(login, password);
//        return initPage(getDriver(), MyAccountPageBase.class);
//    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
