package com.solvd.demoapp.pages.ios;

import com.solvd.demoapp.exception.ImageException;
import com.solvd.demoapp.pages.common.CartPageBase;
import com.solvd.demoapp.pages.common.CatalogPageBase;
import com.solvd.demoapp.pages.common.DrawingPageBase;
import com.solvd.demoapp.pages.common.MenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DrawingPageBase.class)
public class DrawingPage extends DrawingPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(DrawingPage.class);

    @ExtendedFindBy(accessibilityId = "DrawingBackground Icons")
    private ExtendedWebElement drawingBackground;

    public DrawingPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(drawingBackground);
    }

    //todo move to utils if the same for both android and ios?
    public boolean draw(int x, int y, int xa, int ya) throws IOException, ImageException {
        LOGGER.info("draw()");

        String directory = "screenshots/";
        Files.createDirectories(Paths.get(directory));

        File screenshotBefore = new File(directory + "screenshotBefore.png");
        BufferedImage imageBefore = takeScreenshot(getDriver(), screenshotBefore);

        swipe(x, y, xa, ya, 100);

        File screenshotAfter = new File(directory + "screenshotAfter.png");
        BufferedImage imageAfter = takeScreenshot(getDriver(), screenshotAfter);
        return isImageDifferent(imageBefore, imageAfter);
    }

    private BufferedImage takeScreenshot(WebDriver driver, File destination) throws IOException {
        File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), destination.toPath());
        return ImageIO.read(destination);
    }

    private boolean isImageDifferent(BufferedImage before, BufferedImage after) throws ImageException {
        LOGGER.info("isImageDifferent()");
        if (before.getWidth() != after.getWidth() || before.getHeight() != after.getHeight()) {
            throw new ImageException("Comparing wrong images!");
        }
        for (int y = 0; y < before.getHeight(); y++) {
            for (int x = 0; x < before.getWidth(); x++) {
                if (before.getRGB(x, y) != after.getRGB(x, y)) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public CatalogPageBase clickCatalogButton() {
        return null;
    }

    @Override
    public CartPageBase clickCartButton() {
        return null;
    }

    @Override
    public MenuPageBase clickMoreButton() {
        return null;
    }
}
