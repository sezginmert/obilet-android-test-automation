package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utilities.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class Driver {

    public Driver() {
    }

    private static UiAutomator2Options options;
    private static AppiumDriver driver;

    public static AppiumDriver getAppiumDriver() {


        /**  Gercek cihaz icin url "http:0.0.0.0:4723/wd/hub";
         Emilator cihaz icin url "http:127.0.0.1:4723/wd/hub";
         *******   Driver null olduğunda telefonumuza ait özellikleri hazırlarız
         */
        if (driver == null) {
            switch (ConfigReader.getProperty("platformName")) {
                case "Android":
                    options = new UiAutomator2Options();
                    options.setPlatformName("Android").setAutomationName("UiAutomator2");
                     options.setApp("C:\\Users\\Dell\\IdeaProjects\\ObiletMobileTesting\\src\\test\\resources\\obilet.apk");
                    options.setApp("C:\\Users\\Dell\\IdeaProjects\\ObiletMobileTesting\\src\\test\\resources\\Apk Bilgisi_2.3.4_apkcombo.com.apk");
                    options.setAppPackage("com.obilet.androidside");
                    options.setAppActivity("com.obilet.androidside.presentation.screen.splash.activity.SplashScreen");
                    options.setUdid("emulator-5554");
                    options.setNoReset(false);
                    options.autoGrantPermissions();
                    options.setNewCommandTimeout(Duration.ofMinutes(20));
                    try {
                        driver = new AndroidDriver(
                                new URL("http://127.0.0.1:4723"), options
                        );
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                case "IOS":

                    break;
                default:
                    throw new RuntimeException("Desteklenmeyen Platform");
            }
        }

        /**
         * Her test basinda uygulamanin sifirlanmasini ve en bastan olmasini saglar.
         * NoReset=true olursa uygulama kaldigi noktadan devam eder
         */

        return driver;
    }

    public static void quitAppiumDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
