package utilities;


import driver.Driver;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;

import static driver.Driver.getAppiumDriver;
import static java.time.Duration.ofMillis;
import static java.util.Collections.singletonList;
import static org.openqa.selenium.By.xpath;


public class ReusableMethods {
    private static DesiredCapabilities desiredCapabilities = new DesiredCapabilities();



    WebDriver driver;

    public static void apkYukle() {

        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigReader.getProperty("deviceName"));
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigReader.getProperty("version"));
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //desiredCapabilities.setCapability(MobileCapabilityType.APP,ConfigReader.getProperty(apk));
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, ConfigReader.getProperty("appPackage"));
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ConfigReader.getProperty("appActivity"));
    }


    public static void wait(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void koordinatTiklamaMethodu(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        getAppiumDriver().perform(Collections.singletonList(tap));
    }

    public static void ekranKaydirmaMethodu(int xPress, int yPress, int xMove, int yMove, int sureMillis) {
        AppiumDriver driver = Driver.getAppiumDriver();

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        // Parmağın başlangıç noktasına git
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), xPress, yPress));

        // Parmağı bastır
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        // Parmağı hedef noktaya taşı (sureMillis süresince)
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(sureMillis), PointerInput.Origin.viewport(), xMove, yMove));

        // Parmağı kaldır
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Aksiyonu gerçekleştir
        driver.perform(Collections.singletonList(swipe));
    }

    public static void scrollWithUiScrollableAndClick(String elementText) {
        AndroidDriver driver = (AndroidDriver) Driver.getAppiumDriver();

        // Projeye göre özelleşmiş olabilir

        try {
            // Kaydırma işlemi
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().text(\"" + elementText + "\"))"
            ));

            // Öğeyi bulma
            WebElement element = driver.findElement(xpath("//*[@text='" + elementText + "']"));

            // Görünürlük kontrolü ve tıklama
            if (element.isDisplayed()) {
                element.click();
            } else {
                throw new RuntimeException("Element görünür değil: " + elementText);
            }
        } catch (Exception e) {
            throw new RuntimeException("scrollWithUiScrollableAndClick başarısız oldu: " + elementText, e);
        }
    }

    public static void scrollAndSendKeysToElement(String elementText, String inputText) {
        AndroidDriver driver = (AndroidDriver) Driver.getAppiumDriver();

        // Projeye göre özelleşmiş olabilir

        try {
            // Kaydırma işlemi
            WebElement element = driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().text(\"" + elementText + "\"))"
            ));

            // Görünürlük kontrolü, tıklama ve metin gönderme
            if (element.isDisplayed()) {
                element.click();
                element.sendKeys(inputText);
            } else {
                throw new RuntimeException("Element görünür değil: " + elementText);
            }
        } catch (Exception e) {
            throw new RuntimeException("scrollAndSendKeysToElement başarısız oldu: " + elementText, e);
        }
    }



    public static void screenShotElement(String text) throws IOException {
        WebElement element = Driver.getAppiumDriver().findElement(xpath("//*[@text='"+text+"']"));
        Point location = element.getLocation();
        Dimension size = element.getSize();

        // Ekran görüntüsünü alın ve belirli bölgeyi kırpın
        File screenshot = Driver.getAppiumDriver().getScreenshotAs(OutputType.FILE);
        BufferedImage fullImage = ImageIO.read(screenshot);
        BufferedImage croppedImage = fullImage.getSubimage(location.getX(), location.getY(), size.getWidth(), size.getHeight());

        // Kırpılmış görüntüyü kaydedin
        File output = new File("kırpılmış_screenshot.png");
        ImageIO.write(croppedImage, "png", output);

        // Bağlantıyı kapat
        Driver.quitAppiumDriver();
    }


    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot)Driver.getAppiumDriver();

        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }







}
