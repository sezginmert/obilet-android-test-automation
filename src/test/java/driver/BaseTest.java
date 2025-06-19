package driver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setup(){
        Driver.getAppiumDriver();
    }

    @AfterClass
    public void teardown(){
        Driver.quitAppiumDriver();
    }
}
