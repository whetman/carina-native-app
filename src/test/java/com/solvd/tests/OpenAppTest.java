package com.solvd.tests;

import com.solvd.pages.common.HomePageBase;
import org.testng.annotations.Test;

public class OpenAppTest extends AbstractTest{

    @Test
    public void validateAppIsOpening(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
    }
}
