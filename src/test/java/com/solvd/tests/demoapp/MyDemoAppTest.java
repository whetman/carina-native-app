package com.solvd.tests.demoapp;

import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.solvd.tests.AbstractTest;
import org.testng.annotations.Test;

public class MyDemoAppTest extends AbstractTest {

    @Test(testName = "#TC0001", description = "Validate that user can change sorting and from the sorted list of products add a product to the cart and buy it")
    public void validateBuying(){

        //preconditions - user is logged
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
//        RightMenuPageBase rightMenuPage = catalogPage.getFooter().goToRightMenuPage();

//        rightMenuPage.isPageOpened();


    }

}
