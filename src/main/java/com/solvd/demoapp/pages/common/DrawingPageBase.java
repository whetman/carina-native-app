package com.solvd.demoapp.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.InvalidArgumentException;
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

public abstract class DrawingPageBase extends PageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(DrawingPageBase.class);

    @ExtendedFindBy(accessibilityId = "DrawingBackground Icons")
    private ExtendedWebElement drawingBackground;

    @ExtendedFindBy(accessibilityId = "SaveButton Icons")
    private ExtendedWebElement saveButton;

    @ExtendedFindBy(accessibilityId = "ClearButton Icons")
    private ExtendedWebElement clearButton;

    public DrawingPageBase(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(drawingBackground);
    }

    public boolean draw(int x, int y, int xa, int ya) throws IOException {
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

    private boolean isImageDifferent(BufferedImage before, BufferedImage after) {
        LOGGER.info("isImageDifferent()");
        if (before.getWidth() != after.getWidth() || before.getHeight() != after.getHeight()) {
            throw new InvalidArgumentException("Comparing wrong images!"); //todo replace with custom exception
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
}
