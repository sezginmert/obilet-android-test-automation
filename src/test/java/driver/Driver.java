package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utilities.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Driver {

    public Driver() {}

    private static UiAutomator2Options options;
    private static AppiumDriver driver;

    public static AppiumDriver getAppiumDriver() {

        if (driver == null) {
            switch (ConfigReader.getProperty("platformName")) {
                case "Android":
                    options = new UiAutomator2Options();
                    options.setPlatformName("Android")
                            .setAutomationName("UiAutomator2")
                            //.setApp("C:\\Users\\Dell\\IdeaProjects\\ObiletMobileTesting\\src\\test\\resources\\obilet.apk") // Artık gerekli değil
                            .setAppPackage("com.obilet.androidside")
                            .setAppActivity("com.obilet.androidside.presentation.screen.splash.activity.SplashScreen")
                            .setUdid("emulator-5554")
                            .setNoReset(false)        // App data temizlenir (önbellek/logins vs.)
                            .setFullReset(false)      // Uygulama silinmez/yüklenmez
                            .autoGrantPermissions()
                            .setNewCommandTimeout(Duration.ofMinutes(20));

                    try {
                        driver = new AndroidDriver(
                                new URL("http://127.0.0.1:4723"), options
                        );
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }

                    break;

                case "IOS":
                    // iOS konfigürasyonu buraya eklenebilir
                    break;

                default:
                    throw new RuntimeException("Desteklenmeyen Platform");
            }
        }

        return driver;
    }



    public static void quitAppiumDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
