package commonLibs.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    private TakesScreenshot camera;

    public ScreenshotUtils(WebDriver driver) {

        camera = (TakesScreenshot) driver;
    }

    public void captureAndSaveSS(String filename) throws Exception {

        File imageFile = new File(filename);

        // Create folder automatically
        imageFile.getParentFile().mkdirs();

        File tempFile = camera.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(tempFile, imageFile);
    }
}
