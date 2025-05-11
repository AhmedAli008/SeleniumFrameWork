package Tests;

import Config.Properties;
import Pages.UsersPage;
import Utilities.AnnotationUtlis;
import Utilities.JsonUtils;
import annotations.TestCaseTitleAnnotation;
import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.testng.AllureTestNg;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


@Listeners(AllureTestNg.class)
public class UsersTest extends TestBase {

//    String fullName = " Test@008" ;
//    String userName = "Test@008";
//    String email = "Ahmed@008.com";
//    String password = "aA@12345678";
//    String confirmPassword = "aA@12345678";


//    @Test
//    @Description("Create Users")
//    public void CreateNewUser () throws InterruptedException, IllegalAccessException {
//        UsersPage users = new UsersPage(driver);
//        users.openuser();
//        users.CreateUser(fullName , userName ,email , password,confirmPassword );
//    }

    @DataProvider(name = "Create New User")
    public Object[][] createnewuserwithdataprovider (Method method) {
        // Get the test title from annotation
        String testcasetitle = AnnotationUtlis.getTestCaseTitle(method);

        // Debugging: Print test case title
        System.out.println("Fetching data for test case: " + testcasetitle);

        // Retrieve the entire test case JSON object based on the title
        JSONObject testcase = JsonUtils.getJsonDataByTitle(Properties.User_Data_Path, testcasetitle);

        if (testcase != null) {
            // Extract username and password from the test case
            String fullName = (String) testcase.get("fullName");
            String userName = (String) testcase.get("userName");
            String password = (String) testcase.get("password");
            String confirmPassword = (String) testcase.get("confirmPassword");
            String email = (String) testcase.get("email");

            // Return extracted data
            return new Object[][]{{fullName,userName,password,confirmPassword,email}};
        } else {
            throw new RuntimeException("No Data Found for " + testcasetitle);
        }
    }

       // Using DDT extracting from json
       @Test ( dataProvider = "Create New User" )
       @Description("Create Users")
       @TestCaseTitleAnnotation.TestCaseTitle("Create User")
       public  void CreateNewUser (String fullName,String userName,String password,String confirmPassword,String email) throws InterruptedException {
        UsersPage user = new UsersPage(driver);
        user.openuser();
        user.enterfullName(fullName);
        user.enteruserName(userName);
        user.enterpassword(password);
        user.enterconfirmPassword(confirmPassword);
        user.enteremail(email);
        user.selectrole();
       }

}
