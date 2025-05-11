package Pages;

import Utilities.ActionHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private ActionHelper actionHelper;
    // locators for login page
    By usernamefiled = By.id("username");
    By passwordfiled = By.id("password");
    By LoginButton = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div[2]/form/div/div[3]/button");
   // By OriginTech = By.xpath("//*[@id=\"root\"]/div[1]/div/div/div[1]/a/div/img");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.actionHelper = new ActionHelper(driver);
    }

    // public void to use it at method
    public void entertenantusername(String tenantusername) throws InterruptedException {
        actionHelper.settextelementthenEnter(usernamefiled, tenantusername);
    }

    public void entertenantpassword(String tenantpassword) throws InterruptedException {
        actionHelper.settextelementthenEnter(passwordfiled, tenantpassword);
    }

    public void LoginButton() throws InterruptedException {

        Thread.sleep(7000);

        actionHelper.click(LoginButton);
    }

//    public  String getText (){
//     return actionHelper.getText(OriginTech);
//    }

    public void Login(String tenatusername, String tenatpassword) throws InterruptedException {
        entertenantusername(tenatusername);
        entertenantpassword(tenatpassword);
        LoginButton();

    }



    public void Adminlogin ( String tenatusername , String tenatpassword ) throws InterruptedException {
        entertenantusername(tenatusername);
        entertenantpassword(tenatpassword);
        LoginButton();
    }
}


