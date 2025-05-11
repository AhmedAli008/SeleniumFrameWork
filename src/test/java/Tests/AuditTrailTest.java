package Tests;


import Config.Properties;
import Pages.AuditTraliPage;
import Utilities.AnnotationUtlis;
import Utilities.JsonUtils;
import annotations.TestCaseTitleAnnotation;
import base.TestBase;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class AuditTrailTest  extends TestBase {

    @DataProvider(name = "Audit report")
    public Object[][] Audittrail (Method method) {
        // Get the test title from annotation
        String testcasetitle = AnnotationUtlis.getTestCaseTitle(method);

        // Debugging: Print test case title
        System.out.println("Fetching data for test case: " + testcasetitle);

        // Retrieve the entire test case JSON object based on the title
        JSONObject testcase = JsonUtils.getJsonDataByTitle(Properties.Audit_Trail_Path, testcasetitle);

        if (testcase != null) {
            // Extract username and password from the test case
            String regDateFrom = (String) testcase.get("regDateFrom");
            String regDateto = (String) testcase.get("regDateto");
            // Return extracted data
            return new Object[][]{{regDateFrom ,regDateto }};
        } else {
            throw new RuntimeException("No Data Found for " + testcasetitle);
        }
    }
    //@TestCaseTitleAnnotation.TestCaseTitle("Print Audit report")
    @Test
    public  void printAudittrailreport (String fromdate , String todate) throws InterruptedException {
        AuditTraliPage audit = new AuditTraliPage (driver);
        audit.nav();
//        audit.selectfromdates(fromdate);
//        audit.selecttodates(todate);
//        audit.selecttenants();
//        audit.generate();
    }



}
