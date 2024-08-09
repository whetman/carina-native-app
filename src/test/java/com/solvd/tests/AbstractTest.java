package com.solvd.tests;

import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.zebrunner.agent.core.registrar.Screenshot;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class AbstractTest implements IAbstractTest, IMobileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTest.class);

    public void takeScreenshot(){
        LOGGER.info("takeScreenshot()");
        try{
            byte[] screenshotBytes = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            long capturedAtMillis = System.currentTimeMillis();
            Screenshot.upload(screenshotBytes, capturedAtMillis);
        } catch (Exception e) {
            LOGGER.error("Failed to take or upload screenshot");
        }
    }

    @AfterMethod
    public void closeApp() {
        LOGGER.info("closeApp()");
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        catalogPage.terminateApp(R.CONFIG.get("capabilities.bundleId"));
    }

    @AfterSuite
    public void clearScreenshotDirectory() throws IOException {
        LOGGER.info("clearScreenshotDirectory()");
        Files.deleteIfExists(Paths.get(R.CONFIG.get("beforeScreenshotDirectory")));
        Files.deleteIfExists(Paths.get(R.CONFIG.get("afterScreenshotDirectory")));
        Files.deleteIfExists(Paths.get(R.CONFIG.get("screenshotDirectory")));
    }
}
