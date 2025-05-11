package Pages;

import Utilities.ActionHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsersPage {
    private WebDriver  driver;
    private ActionHelper actionHelper;

    By users = By.xpath("//*[@id=\"root\"]/div[1]/div/div/ul/div[9]/div[4]/div[2]/span");
    By newuser_btn = By.cssSelector("button.MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-sizeMedium.MuiButton-containedSizeMedium.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-sizeMedium.MuiButton-containedSizeMedium.css-11mug4v");
    By FullName = By.id("fullName");
    By UserName = By.id("username");
    By Email = By.id("email");
    By Roles = By.id("roles");
    By Password = By.id("password");
    By ConfirmPassword = By.id("confirm");
    By Confirm_Btn = By.xpath("//*[@id=\"root\"]/div[1]/main/form/div[2]/button");

    public UsersPage (WebDriver driver) {
        this.driver = driver;
        this.actionHelper = new ActionHelper(this.driver);
    }

    public void openuser () throws InterruptedException {
        actionHelper.click(users);
        Thread.sleep(2000);
        actionHelper.click(newuser_btn);

    }
//    public void CreateUser (String fullName , String userName , String email , String password , String confirmPassword  ) throws InterruptedException, IllegalAccessException {
//
//        actionHelper.settextelementthenEnter(FullName, fullName );
//        actionHelper.settextelementthenEnter( UserName , userName);
//        actionHelper.settextelementthenEnter( Email , email);
//        actionHelper.settextelementthenEnter( Password , password);
//        actionHelper.settextelementthenEnter(ConfirmPassword , confirmPassword);
//        actionHelper.selecttextelementthenEnter(Roles);
//        actionHelper.click(Confirm_Btn);
//    }

    // Using DDT Methoud

    public void enterfullName (String fullname) throws InterruptedException {
        actionHelper.settextelementthenEnter(FullName, fullname );
    }
    public void enteruserName (String userName) throws InterruptedException {
        actionHelper.settextelementthenEnter(UserName, userName );
    }

    public void enterpassword (String password) throws InterruptedException {
        actionHelper.settextelementthenEnter(Password, password );
    }
    public void enterconfirmPassword (String confirmPassword) throws InterruptedException {
        actionHelper.settextelementthenEnter(ConfirmPassword , confirmPassword );
    }
    public void enteremail (String email) throws InterruptedException {
        actionHelper.settextelementthenEnter(Email, email );
    }
    public void selectrole () throws InterruptedException {
        actionHelper.selecttextelementthenEnter(Roles);
        actionHelper.click(Confirm_Btn);
    }
}
