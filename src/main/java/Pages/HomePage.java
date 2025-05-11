package Pages;

import Utilities.ActionHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver ;
    private ActionHelper actionHelper ;


    By Logouticon = By.xpath("//*[@id=\"root\"]/div[1]/header/div/div/button[1]");
    By Logoutlist = By.xpath("//*[@id=\"menu-appbar\"]/div[3]/ul/li[3]");


    public HomePage (WebDriver driver){
        this.driver = driver ;
        this.actionHelper = new ActionHelper(driver);
    }

    public void Logout () throws InterruptedException {


actionHelper.click(Logouticon);
        Thread.sleep(5000);
       actionHelper.click(Logoutlist);

    }
}
