package utilities;

import driver.Driver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtil {

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public static byte[] captureScreenshot() {
        return ((TakesScreenshot) Driver.getAppiumDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
