package Utilities;

import annotations.TestCaseTitleAnnotation;

import java.lang.reflect.Method;

public class AnnotationUtlis {
    public static String getTestCaseTitle(Method method) {
        if (method == null) {
            return null;
        }
        TestCaseTitleAnnotation.TestCaseTitle annotation = method.getAnnotation(TestCaseTitleAnnotation.TestCaseTitle.class);
        return annotation != null ? annotation.value() : null;
    }
}
