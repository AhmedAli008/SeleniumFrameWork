package Tests;

import Config.Properties;
import Pages.ShipmentFilesPage;
import Utilities.AnnotationUtlis;
import Utilities.JsonUtils;
import annotations.TestCaseTitleAnnotation;
import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.testng.AllureTestNg;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.awt.*;
import java.lang.reflect.Method;


@Listeners(AllureTestNg.class)

public class ShipmentTest extends TestBase {


    @DataProvider(name = "Supplier")
    public Object[][] SupplierName(Method method) {
        // Get the test title from annotation
        String testcasetitle = AnnotationUtlis.getTestCaseTitle(method);

        // Debugging: Print test case title
        System.out.println("Fetching data for test case: " + testcasetitle);

        // Retrieve the entire test case JSON object based on the title
        JSONObject testcase = JsonUtils.getJsonDataByTitle(Properties.Supplier_Name_Path, testcasetitle);

        if (testcase != null) {
            // Extract username and password from the test case
            String username = (String) testcase.get("SupplierName");


            // Return extracted data
            return new Object[][]{{username}};
        } else {
            throw new RuntimeException("No Data Found for " + testcasetitle);
        }
    }


    @Test(dataProvider = "Supplier" ,  priority= 1)
    @TestCaseTitleAnnotation.TestCaseTitle("SupplierName")
    @Description("ShipmentTest")
    public void Shipmentfiles(String SupplierName ) throws InterruptedException, IllegalAccessException, AWTException {

        ShipmentFilesPage ship = new ShipmentFilesPage(driver);
        ship.ShipmentPage(SupplierName);
        ship.UploadShipmentFiles();
        ship.ClickonConfirm();
        ship.AcceptShipment();
        ship.Shipping_OutOrder();
        ship.view_Order();
      //Assert.assertEquals(ship.GetSuccessMesg() , "Automatic Shipped out Success");
    }

    @Test (priority= 2)
    public  void getsscc ( ){
        ShipmentFilesPage shipmentFilesPage = new ShipmentFilesPage(driver);
        shipmentFilesPage.SAVESSCC(shipmentFilesPage.GETSSCC());
        shipmentFilesPage.closepop();
    }

}
