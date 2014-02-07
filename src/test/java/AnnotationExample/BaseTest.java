package AnnotationExample;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * User: maksmac
 */
public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void testSetup(){
        System.out.println("Message from testSetup of Base Test Class");
    }

    @Test
    public void test(){
        System.out.println("Message from test of Base Test Class");
    }

    @AfterMethod
    public void testCleanup() {
        System.out.println("Message from testCleanup of Base Test Class");
    }
}
