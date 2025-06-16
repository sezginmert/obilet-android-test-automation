package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class BrowserDriver {

    private static AndroidDriver driver;

    public static AndroidDriver getBrowserDriver() {
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            // Cihaz özellikleri
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // Cihaz adı
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.0"); // Android sürüm numarası
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome"); // Tarayıcı olarak Chrome kullanılacak
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability(MobileCapabilityType.NO_RESET, true); // Cihazın sıfırlanmasını engeller

            // Appium'un otomatik mobil uygulama başlatmasını engellemek için appPackage ve appActivity kaldırıyoruz
            // capabilities.setCapability("appPackage", "com.android.chrome"); // Bu satırın olmaması gerekir
            // capabilities.setCapability("appActivity", "com.android.chrome.Main"); // Bu satırın olmaması gerekir

            // Doğru chromedriver yolunu belirtiyoruz
            capabilities.setCapability("chromedriverExecutable", "C:\\Users\\Oguz\\IdeaProjects\\NetCAD_AppiumProject\\src\\test\\java\\apps\\app-release 33.apk"); // Windows için

            try {
                URL appiumServerUrl = new URL("http://127.0.0.1:4723"); // Appium sunucu URL'si
                driver = new AndroidDriver(appiumServerUrl, capabilities);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Appium server URL hatalı: http://127.0.0.1:4723");
            }
        }

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
