package com.solvd.tests.swaglabs;

import com.solvd.swaglabs.pages.common.LoginPageBase;
import com.solvd.tests.AbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.utils.resources.L10N;
import com.zebrunner.carina.webdriver.config.WebDriverConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Locale;

public class LocalizationTest extends AbstractTest {

    @Test
    public void validateLocaleLoad(){
        Locale locale = L10N.getLocale();
        String loadedLocale = locale.getLanguage() + "_" + locale.getCountry();
        String configLocale = Configuration.getRequired(WebDriverConfiguration.Parameter.LOCALE);
        Assert.assertEquals(loadedLocale, configLocale);
    }

    @Test
    public void validateGermanLanguage(){
        R.CONFIG.put("locale", "de_DE");
        L10N.setLocale(R.CONFIG.get("locale"));
        L10N.load();

        SoftAssert softAssert = new SoftAssert();

        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        String usernameFieldText = loginPage.getUsernameField().getAttribute("value");
        softAssert.assertEquals(usernameFieldText, L10N.getText("LoginPage.usernameField.text"), "Incorrect language in username field!");
        String passwordFieldText = loginPage.getPasswordField().getAttribute("value");
        softAssert.assertEquals(passwordFieldText, L10N.getText("LoginPage.passwordField.text"), "Incorrect language in password field!");
        takeScreenshot();
        softAssert.assertAll();

    }
}
