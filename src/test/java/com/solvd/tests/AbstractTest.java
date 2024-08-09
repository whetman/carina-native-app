package com.solvd.tests;

import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class AbstractTest implements IAbstractTest, IMobileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTest.class);

    @AfterMethod
    public void closeApp() {
        LOGGER.info("closeApp()");
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        catalogPage.terminateApp(R.CONFIG.get("capabilities.bundleId"));
    }

    @AfterSuite
    public void clearScreenshotDirectory() throws IOException {
        LOGGER.info("clearScreenshotDirectory()");
        String directory = "screenshots/";
        String before = "screenshots/screenshotBefore.png";
        String after = "screenshots/screenshotAfter.png";
        Files.deleteIfExists(Paths.get(before));
        Files.deleteIfExists(Paths.get(after));
        Files.deleteIfExists(Paths.get(directory));
    }
}
