package Tests;


import Pages.VerifyStatusPage;
import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;

@Listeners(AllureTestNg.class)
public class VerifyStatusTest extends TestBase {

    @Test
    @Description ("Scan SSCC at verify status")
    public  void verifySSCC () throws AWTException, InterruptedException {
        VerifyStatusPage verify = new VerifyStatusPage(driver);
        verify.verifystatus();
    }
    @Test (priority = 2)
    @Step ("Retrieve SSCC")
    public  String GetSSCC (VerifyStatusPage verifystatus ){
        return verifystatus.getSSCC();
    }
    @Test (priority = 3)
    @Step ("Search SSCC")
    public  void SearchSSCC  (VerifyStatusPage verifystatus , String sscc ) throws InterruptedException {
        verifystatus.EnterSSCC(sscc);
    }
}


