package Pages;

import Utilities.ActionHelper;
import Utilities.JsonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.io.File;

public class VerifyStatusPage {
    private WebDriver driver ;
    private ActionHelper actionHelper ;

    By Verifystatus_btn = By.xpath("//*[@id=\"root\"]/div[1]/div/div/ul/div[2]/div[2]/span");
    By scanbarcode = By.id("outlined-basic");



    public VerifyStatusPage( WebDriver driver) {
        this.driver = driver ;
        this.actionHelper = new ActionHelper(driver);

    }

    public void verifystatus () throws AWTException, InterruptedException {
        actionHelper.click(Verifystatus_btn);
        Thread.sleep(2000);
        actionHelper.OpenVirtualscanner();

//        {
//            // Set Chrome options to load extension
//            ChromeOptions options = new ChromeOptions();
//            options.addExtensions(new File("D:\\Ahmed_Ali\\Extensions\\build 1\\build.crx"));
//
//            options.addArguments("--disable-extensions-http-throttling");
//            options.addArguments("--disable-web-security");
//            options.addArguments("--allow-insecure-localhost");
//
//            // Initialize driver with options
//            driver = new ChromeDriver(options);
//
//            // If you need to interact with the extension's popup:
//            String extensionId = "gmnafijplmggmijmoefmlffkdmkdkiac"; // Get this from chrome://extensions
//            //driver.get("chrome-extension://" + extensionId + "/index.html");
//            WebElement extensionButton = driver.findElement(
//                    By.cssSelector("extensions-toolbar > div#toolbar > div#extensions"));
//            extensionButton.click();
//
//        }
    }
    public String getSSCC (){
        return JsonUtils.GetSSCCserialfromjsonlist();
    }

    public  void EnterSSCC (String sscc) throws InterruptedException {

        actionHelper.settextelementthenEnter( scanbarcode , sscc );
    }

}
