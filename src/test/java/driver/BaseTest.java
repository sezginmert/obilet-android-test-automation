package driver;

import io.appium.java_client.AppiumDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import utilities.LoggerHelper;
import utilities.ReusableMethods;
import utilities.ScreenshotUtil;

public class BaseTest {

    LoggerHelper loggerHelper = new LoggerHelper();

    @BeforeClass
    public void setup() {
        Driver.getAppiumDriver();
        ReusableMethods.wait(15);
        loggerHelper.info("Appium driver initialized before the test class.");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenshotUtil.captureScreenshot();  // Allure'a ekran görüntüsü eklenir
            loggerHelper.error("Test failed. Screenshot captured.");
        }
        Driver.quitAppiumDriver();  // Screenshot'tan sonra kapat
    }

    @AfterClass
    public void teardownClass() {
        loggerHelper.info("Test class completed.");
    }
}
