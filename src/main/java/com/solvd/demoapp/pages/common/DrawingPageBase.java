package com.solvd.demoapp.pages.common;

import com.solvd.demoapp.exception.ImageException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public abstract class DrawingPageBase extends PageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(DrawingPageBase.class);

    public DrawingPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean draw(int x, int y, int xa, int ya) throws IOException, ImageException;

}
