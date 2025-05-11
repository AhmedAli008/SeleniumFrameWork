package Pages;

import Utilities.ActionHelper;
import Utilities.JsonUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class ShipmentFilesPage {
    private WebDriver driver;
    private ActionHelper actionHelper;

    // old By ShipmentFilesIcon = By.xpath("//*[@id=\"root\"]/div[1]/main/div[2]/div[3]/div/button");
    By ShipmentFilesIcon = By.cssSelector("div.MuiGrid-root > div:nth-child(3) button.MuiButtonBase-root");
    By AddNewFile = By.xpath("//*[@id=\"root\"]/div[1]/main/div[4]/button");
    By Selectsupplierfromlist = By.id("supplier");
    By UploadFileBtn = By.xpath("//*[@id=\"root\"]/div[1]/main/form/div[1]/div/div/div[2]/div/div/div");
    By Confirm_Btn = By.xpath("//*[@id=\"root\"]/div[1]/main/form/div[2]/button");
    By RowActions = By.cssSelector("button.MuiButtonBase-root.MuiIconButton-root.MuiIconButton-sizeSmall.css-1hhhz6a");
    By Accept = By.cssSelector(".MuiButtonBase-root.MuiMenuItem-root.MuiMenuItem-gutters.MuiMenuItem-root.MuiMenuItem-gutters.css-r2hyib");
    By PopConfirm = By.xpath("/html/body/div[4]/div[3]/div/div[3]/button[2]");
    By Close_btn = By.xpath("/html/body/div[4]/div[3]/div/div[3]/button");
    By View = By.xpath("/html/body/div[4]/div[3]/ul/li[2]/p");
    By Shipout = By.xpath("/html/body/div[4]/div[3]/ul/li[4]/p");
    By partners = By.id("partner");
    By partner_Submit = By.xpath("/html/body/div[4]/div[3]/div/form/div[3]/div/button");
    By Close_pop = By.xpath("/html/body/div[4]/div[3]/div/div[1]/button");
    //By Succes_Mesg = By.cssSelector(".MuiTypography-root.MuiTypography-body1.css-1cvke54");
    By view_Btn = By.xpath("/html/body/div[4]/div[3]/ul/li[3]/p");
    By SSCC = By.xpath("/html/body/div[4]/div[3]/div/div[2]/div[1]/table/tbody/tr[1]/td[1]");
    By view_close = By.xpath("/html/body/div[4]/div[3]/div/div[1]/button");

    public ShipmentFilesPage(WebDriver driver) {
        this.driver = driver;
        this.actionHelper = new ActionHelper(driver);
    }

    public void ShipmentPage(String Supplier) throws IllegalAccessException, InterruptedException {
        actionHelper.click(ShipmentFilesIcon);
        actionHelper.click(AddNewFile);
      //  actionHelper.settextelementthenEnter(Selectsupplierfromlist, Supplier);
        actionHelper.selecttextelementthenEnter(Selectsupplierfromlist);
        Thread.sleep(2000);

    }

    public void UploadShipmentFiles() throws InterruptedException, AWTException {
        String filename ="SF_28-04-2025_Ahmed.Ali_33234973";
        String path = System.getProperty("user.dir") + "\\UploadFile\\" + filename;
        System.out.println(System.getProperty("user.dir"));
        actionHelper.click(UploadFileBtn);
        actionHelper.UploadFile(UploadFileBtn, path);
        Thread.sleep(2000);
    }

    public void ClickonConfirm() throws InterruptedException {
        actionHelper.click(Confirm_Btn);
        Thread.sleep(4000);
    }

    public void AcceptShipment() throws IllegalAccessException, InterruptedException {
        actionHelper.click(RowActions);
        Thread.sleep(2000);
        actionHelper.click(Accept);
        Thread.sleep(2000);
        actionHelper.click(PopConfirm);
        Thread.sleep(2000);
        actionHelper.click(Close_btn);
    }

    public void Shipping_OutOrder() throws InterruptedException {
        actionHelper.click(RowActions);
        actionHelper.click(Shipout);
        actionHelper.selecttextelementthenEnter(partners);
        Thread.sleep(2000);
        actionHelper.click(partner_Submit);
        Thread.sleep(2000);
        actionHelper.click(Close_pop);
    }
    public void view_Order() throws InterruptedException {
        actionHelper.click(RowActions);
        Thread.sleep(2000);
        actionHelper.click(view_Btn);
        Thread.sleep(2000);
    }

    public String GETSSCC (){
        return  actionHelper.getText(SSCC);
    }
    public void SAVESSCC (String SSCC ){
        JsonUtils.saveSSCCNumberToJson (SSCC);
    }
    public void closepop (){
        actionHelper.click(view_close);
    }

//    public String GetSuccessMesg() {
//        return actionHelper.getText(Succes_Mesg);
//    }
}
