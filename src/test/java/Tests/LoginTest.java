package Tests;

import Config.Properties;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.AnnotationUtlis;
import Utilities.JsonUtils;
import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.testng.AllureTestNg;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static annotations.TestCaseTitleAnnotation.*;


@Listeners({AllureTestNg.class})
public class LoginTest extends TestBase {

    @DataProvider(name = "TenantData")
    public Object[][] Loginwithdataprovider(Method method) {
        // Get the test title from annotation
        String testcasetitle = AnnotationUtlis.getTestCaseTitle(method);

        // Debugging: Print test case title
        System.out.println("Fetching data for test case: " + testcasetitle);

        // Retrieve the entire test case JSON object based on the title
        JSONObject testcase = JsonUtils.getJsonDataByTitle(Properties.Login_Data_Path, testcasetitle);

        if (testcase != null) {
            // Extract username and password from the test case
            String username = (String) testcase.get("tenantusername");
            String password = (String) testcase.get("tenantpassword");

            // Return extracted data
            return new Object[][]{{username, password}};
        } else {
            throw new RuntimeException("No Data Found for " + testcasetitle);
        }
    }

    @Test(priority = 1)
    @Description("Logout")
    public void logout() {
        HomePage homePage = new HomePage(driver);
        try {
            homePage.Logout();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(dataProvider = "TenantData", priority = 3)
    @TestCaseTitle("invalid user name")
    @Description("Login With invalid user ")
    public void invalidlogin(String tenantusername, String tenantpassword) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.entertenantusername(tenantusername);
        loginPage.entertenantpassword(tenantpassword);
        loginPage.LoginButton();
        // Assert.assertEquals(loginPage.getText(), "Welcome Back", "Login Failed");
    }

    @Test(dataProvider = "TenantData", priority = 2)
    @TestCaseTitle("Amman")
    @Description("Login With Amman Pharmaceutical Industries")
    public void login(String tenantusername, String tenantpassword) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.entertenantusername(tenantusername);
        loginPage.entertenantpassword(tenantpassword);
        loginPage.LoginButton();
        homePage.Logout();

        //Assert.assertEquals(loginPage.getText(), "Welcome Back", "Login Success");
    }
}
