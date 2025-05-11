package annotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class TestCaseTitleAnnotation {



    // This annotation can be used to specify the test case title for each test method
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TestCaseTitle {
        String value(); // This element holds the test case title
    }


}