package utilities;

import driver.Driver;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String getScreenshot(String name) throws IOException {
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) Driver.getAppiumDriver();

        File source = ts.getScreenshotAs(OutputType.FILE);
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        FileUtils.copyFile(source, finalDestination);

        // Allure için byte[] olarak ekleniyor
        attachScreenshotToAllure(finalDestination);

        return target;
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    private static byte[] attachScreenshotToAllure(File file) throws IOException {
        return Files.readAllBytes(file.toPath());
    }

}
