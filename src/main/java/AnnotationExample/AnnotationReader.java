package AnnotationExample;

import com.beust.jcommander.internal.Lists;
import org.testng.*;

import java.util.List;

/**
 * User: maksmac
 */
public class AnnotationReader implements ITestListener {

    private static final Class<UsingTest> ANNOTATION_TYPE = UsingTest.class;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println(iTestResult);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        List<ITestClass> testClasses = Lists.newArrayList(((TestRunner) iTestContext).getTestClasses());
        ITestClass currentTestClass = testClasses.get(0);
        Class<?> clazz = null;
        try {
            clazz = Class.forName(currentTestClass.getName());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found "+e);
        }

        System.out.println(clazz.getSimpleName());
        UsingTest usingTest = clazz.getAnnotation(ANNOTATION_TYPE);
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        try {
            testng.setTestClasses(new Class[] { Class.forName(usingTest.value()) });
        } catch (ClassNotFoundException e) {
            System.out.println("could not find class"+e);
        }
        testng.addListener(tla);
        testng.run();

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
