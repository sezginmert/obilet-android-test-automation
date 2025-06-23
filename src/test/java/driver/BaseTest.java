package driver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import utilities.LoggerHelper;
import utilities.ReusableMethods;
import utilities.ScreenshotUtil;

import java.io.IOException;

public class BaseTest {

    LoggerHelper loggerHelper = new LoggerHelper();

    @BeforeClass
    public void setup() {
        Driver.getAppiumDriver();
        ReusableMethods.wait(15);
        loggerHelper.info("Appium driver initialized before the test class.");
    }

    @AfterClass
    public void teardown() {
        Driver.quitAppiumDriver();
        loggerHelper.info("Appium driver terminated after the test class.");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                ScreenshotUtil.getScreenshot("failure_");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Driver.quitAppiumDriver();
    }



}
