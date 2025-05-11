package Pages;

import Utilities.ActionHelper;
import Utilities.NavigationHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuditTraliPage {

    private WebDriver driver ;
    private ActionHelper actionHelper ;
    private NavigationHelper navigate  ;

    By Reports = By.xpath("//*[@id=\"root\"]/div[1]/div/div/ul/div[7]/div[2]/span");
    By History = By.xpath("//*[@id=\"root\"]/div[1]/div/div/ul/div[8]/div/div/div/div[1]/div[2]/span");
    By Audittrail = By.xpath("//*[@id=\"root\"]/div[1]/div/div/ul/div[8]/div/div/div/div[2]/div/div/div/div/div/span");
    By FromDate = By.id("fromDate");
    By DateTo = By.id("toDate");
    By Sites = By.id("tenants");
    By Generate = By.xpath("//*[@id=\"root\"]/div[1]/main/form/div/div/div/div[4]/button");

    public  AuditTraliPage  (WebDriver driver){
        this.driver = driver ;
        this.actionHelper= new ActionHelper(driver);
        this.navigate = new NavigationHelper(driver);
   }

//    public void NavigatetoAuditTrailScreeen (){
//        navigate.navigationtomenue( "Reports" , "History" , "Audit Trail");
//    }

    public void nav (){
    driver.navigate().to("https://wes.test.originsysglobal.com/auditTrail-report");
    }

//    public void Naviagtetopage (){
//        actionHelper.click(Reports);
//        actionHelper.click(History);
//        actionHelper.click(Audittrail);
//    }

//    public void selectfromdates (String fromdate) {
//        actionHelper.sendkeys(FromDate, fromdate);
//    }
//
//    public void selecttodates (String todate)  {
//        actionHelper.sendkeys(DateTo, todate);
//    }
//
//    public void selecttenants () throws InterruptedException {
//        actionHelper.selecttextelementthenEnter(Sites);
//        }
//
//        public  void generate (){
//        actionHelper.click(Generate);
//    }


}
