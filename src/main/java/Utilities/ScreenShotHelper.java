package Utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotHelper {

    private WebDriver driver;
    private ActionHelper actionHelper;

    public ScreenShotHelper(WebDriver driver) {
        this.driver = driver;
        this.actionHelper = new ActionHelper(driver);
    }

    public void takeScreenshot(String filePath) {
        // Convert web driver object to TakeScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // Call getScreenshotAs method to create the screenshot as a file
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        // Copy the screenshot to the specified destination
        try {
            File destFile = new File(filePath);
            FileHandler.copy(srcFile, destFile);
            System.out.println("Screenshot saved at: " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }

    // Method to take a screenshot with a unique name using a timestamp
    public void UploadFile() {
        // Use timestamp to generate a unique file name
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String screenshotPath = "D:\\Ahmed_Ali\\Origin_Auto\\untitled\\Failed screen shoots"
                + timestamp + ".png";
        takeScreenshot(screenshotPath);
    }

}