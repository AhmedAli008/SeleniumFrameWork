package base;

import Pages.HomePage;
import Pages.LoginPage;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase {
    public static WebDriver driver;


    @BeforeSuite
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://wes.test.originsysglobal.com/");
        login();
    }

    public void login() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Adminlogin("6251151000003_admin", "admin");
         //Assert.assertEquals(loginPage.getText() ,"Welcom back:" , "Login Succes");

    }

    @AfterMethod
    public void pauseBetweenTests() throws InterruptedException {
        Thread.sleep(2000);
    }

//    @AfterMethod
//    public void captureScreenshotAfterMethod(ITestResult result) {
//        if (result.getStatus() == ITestResult.FAILURE) {
//            attachScreenshot();
//        }
//    }
//
//    @Attachment(value = "Screenshot on Failure", type = "image/png")
//    public byte[] attachScreenshot() {
//        try {
//            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            return Files.readAllBytes(Paths.get(screenshot.getAbsolutePath()));
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

//    public void taketScreenshot() {
//        // Use timestamp to generate a unique file name
//        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//        String screenshotPath = "D:\\Ahmed_Ali\\Origin_Auto\\Failed screen shoots" + timestamp + ".png";
//        takeScreenshot(screenshotPath);
//    }

//    public void takeScreenshot(String filePath) {
//        // Convert web driver object to TakeScreenshot
//        TakesScreenshot screenshot = (TakesScreenshot) driver;
//
//        // Call getScreenshotAs method to create the screenshot as a file
//        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
//
//        // Copy the screenshot to the specified destination
//        try {
//            File destFile = new File(filePath);
//            FileHandler.copy(srcFile, destFile);
//            System.out.println("Screenshot saved at: " + filePath);
//        } catch (IOException e) {
//            System.out.println("Failed to save screenshot: " + e.getMessage());
//        }
//    }

//    @AfterSuite
//    public void tearDown() {
//        driver.quit();
//    }
////
}
