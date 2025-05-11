package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    private WebDriver driver ;
    private ActionHelper actionHelper ;

    public NavigationHelper (WebDriver driver){
        this.actionHelper = new ActionHelper(driver);
        this.driver = driver ;
    }

    public void navigationtomenue (String mainMenuLocator , String Submenu1Locator , String submenu3Locator){
        By mainMenuLocatorLinktext = By.linkText(mainMenuLocator);
        By Submenu1Locatorlinktext = By.linkText(Submenu1Locator);
        By submenu3LocatorLinktext = By.linkText(submenu3Locator);
        actionHelper.click(mainMenuLocatorLinktext);
        actionHelper.click(Submenu1Locatorlinktext);
        actionHelper.click(submenu3LocatorLinktext);

    }


}
