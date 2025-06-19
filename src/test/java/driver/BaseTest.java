package driver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.LoggerHelper;

public class BaseTest {

    LoggerHelper loggerHelper = new LoggerHelper();

    @BeforeClass
    public void setup() {
        Driver.getAppiumDriver();
        loggerHelper.info("Appium driver initialized before the test class.");
    }

    @AfterClass
    public void teardown() {
        Driver.quitAppiumDriver();
        loggerHelper.info("Appium driver terminated after the test class.");
    }
}
